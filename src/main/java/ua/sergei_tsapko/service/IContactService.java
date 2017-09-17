package ua.sergei_tsapko.service;

import ua.sergei_tsapko.domain.Contact;

import java.util.List;

public interface IContactService {
    List<Contact> getByFilter(String nameFilter);
}
