package fr.codebusters.hellospring.service;

import fr.codebusters.hellospring.entity.Greeting;
import fr.codebusters.hellospring.exception.GreetingNotFoundException;
import fr.codebusters.hellospring.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("greetingServiceRest")
public class GreetingServiceRest implements GreetingService {

    private GreetingRepository greetingRepository;

    public GreetingServiceRest(GreetingRepository greetingRepository){
        this.greetingRepository = greetingRepository;
    }

    public Greeting read(Long id){
        return greetingRepository.findById(id)
                .orElseThrow(() -> new GreetingNotFoundException("Greeting with id : " + id + " is not found"));
    }

    public Greeting save(Greeting greeting){
        return greetingRepository.save(greeting);
    }

    public void delete(Long id){
        greetingRepository.deleteById(id);
    }

    public List<Greeting> list(){
        return greetingRepository.findAll();
    }

    public List<Greeting> saveAll(List<Greeting> greetings){
        return greetingRepository.saveAll(greetings);
    }
}
