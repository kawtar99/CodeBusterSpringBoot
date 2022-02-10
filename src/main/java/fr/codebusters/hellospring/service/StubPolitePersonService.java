package fr.codebusters.hellospring.service;

import fr.codebusters.hellospring.entity.Greeting;
import fr.codebusters.hellospring.entity.PolitePerson;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
@Qualifier("politePersonStub")
public class StubPolitePersonService implements PolitePersonService{

    private PolitePerson politePerson;

    public StubPolitePersonService() {
        this.politePerson.setId(1L);

        Greeting g1= new Greeting(100L, "Hello!");
        Greeting g2 = new Greeting(200L, "Good Morning!");
        this.politePerson.setFavoriteGreetings(Set.of(g1, g2));
    }

    @Override
    public PolitePerson read(Long id) {
        return politePerson;
    }

    @Override
    public PolitePerson save(PolitePerson politePerson) {
        return politePerson;
    }

    @Override
    public void delete(Long id) {

    }
}
