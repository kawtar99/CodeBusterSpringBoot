package fr.codebusters.hellospring.service;

import fr.codebusters.hellospring.entity.Greeting;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@Qualifier("stubService")
public class StubService implements GreetingService{

    Greeting test = new Greeting(1L, "Stub Test");

    @Override
    public Greeting read(Long id) {
        return test;
    }

    @Override
    public Greeting save(Greeting greeting) {
        return greeting;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Collection<Greeting> list() {
        return List.of(test);
    }

    @Override
    public List<Greeting> saveAll(List<Greeting> greetings) {
        return null;
    }
}
