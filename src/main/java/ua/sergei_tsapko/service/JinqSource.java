package ua.sergei_tsapko.service;

import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.springframework.stereotype.Component;
import ua.sergei_tsapko.domain.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Component
public class JinqSource {
    private JinqJPAStreamProvider streams;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) throws Exception {
        streams = new JinqJPAStreamProvider(emf);
    }

    public <T> JPAJinqStream<T> streamAll(EntityManager em, Class<T> entity){
        return streams.streamAll(em, entity);
    }

    public JPAJinqStream<Contact> contacts(EntityManager em){
        return streams.streamAll(em, Contact.class);
    }
}
