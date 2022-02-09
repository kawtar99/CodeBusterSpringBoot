package fr.codebusters.hellospring.service;

import fr.codebusters.hellospring.entity.Greeting;
import fr.codebusters.hellospring.repository.GreetingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class GreetingServiceTest {

    @InjectMocks
    private GreetingService greetingService;

    @MockBean
    private GreetingRepository greetingRepository;

    @BeforeEach
    public void setUp(){
        greetingService = new GreetingService(greetingRepository);

        Greeting g1 = new Greeting(1L, "First Greeting");

        when(greetingRepository.getById(100L)).thenReturn(null);
        when(greetingRepository.getById(1L)).thenReturn(g1);
    }

    @Test
    void shouldReadNonexistentGreeting() {

        Greeting result = greetingService.read(100L);
        assertNull(result);
    }

    @Test
    void shouldReadExistentGreeting() {
        Greeting result = greetingService.read(1L);

        assertEquals(result.getId(), 1L);
        assertEquals(result.getMessage(), "First Greeting");
    }

    @Test
    void save() {
    }

    @Test
    void list() {
    }
}