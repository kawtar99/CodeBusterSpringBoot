package fr.codebusters.hellospring.service;

import fr.codebusters.hellospring.entity.Greeting;
import fr.codebusters.hellospring.exception.GreetingNotFoundException;
import fr.codebusters.hellospring.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    private GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository){
        this.greetingRepository = greetingRepository;
    }

    public Greeting read(Long id){
        return greetingRepository.findById(id)
                .orElseThrow(() -> new GreetingNotFoundException("Greeting with id : " + id + " is not found"));
    }

    public Greeting save(Greeting greeting){
        return greetingRepository.save(greeting);
    }

    public List<Greeting> list(){
        return greetingRepository.findAll();
    }
    /*
    private static Long idGenerator = 0L;

    Map<Long, Greeting> greetings = new HashMap<>();

    public Greeting read(Long id){
        return greetings.get(id);
    }

    public Greeting save(Greeting greeting){
        Long id = greeting.getId();
        Greeting result = (id == null || !greetings.containsKey(id))
                ? new Greeting(++idGenerator, greeting.getMessage())
                : greeting;
        greetings.put(result.getId(), result);
        return result;
    }


    public Collection<Greeting> list(){
        return greetings.values();
    }
     */
}
