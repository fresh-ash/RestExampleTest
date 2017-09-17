package ua.sergei_tsapko.service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.sergei_tsapko.domain.Contact;
import ua.sergei_tsapko.repository.ContactRepository;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactServiceTest{

    @Autowired
    private ContactRepository contact;

    @Autowired
    private ContactService service;

    @Test
    public void testGetByFilterReturnWorld(){
        Contact c = this.contact.save(new Contact("Hello"));
        c = this.contact.save(new Contact("world"));
        List<Contact> result = this.service.getByFilter("^H.*$");
        assertEquals("world", result.get(0).getName());
    }

    @Test
    public void testGetByFilterReturnHello(){
        Contact c = this.contact.save(new Contact("Hello"));
        c = this.contact.save(new Contact("world"));
        List<Contact> result = this.service.getByFilter("^.*d$");
        assertEquals("Hello", result.get(0).getName());
    }

    @Test
    public void testGetByFilterReturnNotNull(){
        Contact c = this.contact.save(new Contact("Hello"));
        c = this.contact.save(new Contact("world"));
        List<Contact> result = this.service.getByFilter("^.*[k].*$");
        assertNotNull(result);
    }





}
