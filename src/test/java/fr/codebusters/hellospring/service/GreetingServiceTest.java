package fr.codebusters.hellospring.service;

import fr.codebusters.hellospring.entity.Greeting;
import fr.codebusters.hellospring.exception.GreetingNotFoundException;
import fr.codebusters.hellospring.repository.GreetingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class GreetingServiceTest {

    @Autowired
    @Qualifier("greetingServiceRest")
    private GreetingService greetingService;

    @MockBean
    private GreetingRepository greetingRepository;

    private Collection<Greeting> collection;

    @BeforeEach
    public void setUp(){
        greetingService = new GreetingServiceRest(greetingRepository);

        Greeting g1 = new Greeting(1L, "First Greeting");
        Greeting g2 = new Greeting(2L, "Second Greeting");

        collection = List.of(g1, g2);

        when(greetingRepository.findById(1L)).thenReturn(Optional.of(g1));
        when(greetingRepository.findAll()).thenReturn(List.of(g1, g2));
    }

    @Test
    void shouldReadNonexistentGreeting() {
        Throwable e = assertThrows(GreetingNotFoundException.class,
                () -> greetingService.read(100L));

        assertEquals(e.getMessage(), "Greeting with id : 100 is not found");
    }

    @Test
    void shouldReadExistentGreeting() {
        Greeting result = greetingService.read(1L);

        assertEquals(result.getId(), 1L);
        assertEquals(result.getMessage(), "First Greeting");
    }

    @Test
    void shouldSaveGreeting() {
        Greeting g3 = new Greeting(3L, "Third Greeting");
        when(greetingRepository.save(g3)).thenReturn(g3);
        Greeting result = greetingService.save(g3);

        assertEquals(result.getId(), 3L);
        assertEquals(result.getMessage(), "Third Greeting");
    }

    @Test
    void shouldListAllGreetings() {
        Collection<Greeting> greetings = greetingService.list();

        assertEquals(greetings.size(), 2);
        assertTrue(greetings.containsAll(collection));
    }
}