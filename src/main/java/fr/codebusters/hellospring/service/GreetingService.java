package fr.codebusters.hellospring.service;

import fr.codebusters.hellospring.entity.Greeting;
import fr.codebusters.hellospring.exception.GreetingNotFoundException;
import fr.codebusters.hellospring.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


public interface GreetingService {

    public Greeting read(Long id);

    public Greeting save(Greeting greeting);

    public void delete(Long id);

    public Collection<Greeting> list();

    public List<Greeting> saveAll(List<Greeting> greetings);

}
