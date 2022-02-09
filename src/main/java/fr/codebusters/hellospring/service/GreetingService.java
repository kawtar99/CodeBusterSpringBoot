package fr.codebusters.hellospring.service;

import fr.codebusters.hellospring.entity.Greeting;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingService {

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

}
