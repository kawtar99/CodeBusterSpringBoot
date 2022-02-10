package fr.codebusters.hellospring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.codebusters.hellospring.entity.Greeting;
import fr.codebusters.hellospring.service.GreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Qualifier("greetingServiceRest")
    private GreetingService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Greeting g3;

    @BeforeEach
    public void setUp(){

        Greeting g1 = new Greeting(1L, "first greeting");
        Greeting g2 = new Greeting(2L, "second greeting");

        when(service.list()).thenReturn(List.of(g1, g2));

        when(service.read(220L)).thenReturn(null);
        when(service.read(1L)).thenReturn(g1);

        g3 = new Greeting(3L, "third greeting");
        when(service.save(g3)).thenReturn(g3);

    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello Spring Boot!")));
    }

    @Test
    void shouldListAllGreetings() throws Exception {
        this.mockMvc.perform(get("/greetings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)));
    }

    @Test
    void shouldListEmptyGreetings() throws Exception {
        when(service.list()).thenReturn(List.of());

        this.mockMvc.perform(get("/greetings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(0)));
    }

    @Test
    void shouldGet404StatusWhenGreetingNotFound() throws Exception {
        this.mockMvc.perform(get("/greetings/220"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldGetGreetingObjectFromExistingId() throws Exception {
        this.mockMvc.perform(get("/greetings/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.message", is("first greeting")));
    }

    @Test
    void shouldCreateGreetingObject() throws Exception {
        this.mockMvc.perform(post("/greetings")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(g3)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.message", is("third greeting")));
    }
}