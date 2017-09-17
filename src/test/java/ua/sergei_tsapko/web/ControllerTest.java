package ua.sergei_tsapko.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ua.sergei_tsapko.domain.Contact;
import ua.sergei_tsapko.service.ContactService;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
public class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ContactService services;

    @Test
    public void tttt() throws Exception{
        List<Contact> list = Collections.singletonList(new Contact("world"));
        ObjectMapper mapper = new ObjectMapper();
        String filter = "^w.*$";
        given(this.services.getByFilter(filter)).willReturn(list);
        this.mvc.perform(get("/hello/contacts?nameFilter=" + filter).accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(status().isOk()
        ).andExpect(content().string(mapper.writeValueAsString(list)));
    }
}
