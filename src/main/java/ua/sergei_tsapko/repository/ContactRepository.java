package ua.sergei_tsapko.repository;

import org.springframework.data.repository.CrudRepository;
import ua.sergei_tsapko.domain.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
