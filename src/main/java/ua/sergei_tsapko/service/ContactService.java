package ua.sergei_tsapko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.sergei_tsapko.domain.Contact;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


import static java.util.regex.Pattern.matches;
import static java.util.stream.Collectors.toList;

@Service
public class ContactService implements IContactService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private JinqSource source;

    @Override
    public List<Contact> getByFilter(final String nameFilter) {
        return source.contacts(em).filter(c -> !matches(nameFilter, c.getName())).collect(toList());
    }

}
