package ua.sergei_tsapko.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.sergei_tsapko.domain.Contact;
import ua.sergei_tsapko.service.ContactService;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private ContactService services;

    @GetMapping(value = "/hello/contacts", params = {"nameFilter"})
    @ResponseBody
    List<Contact> hello(@RequestParam(value = "nameFilter") String nameFilter){
        return this.services.getByFilter(nameFilter);
    }

}
