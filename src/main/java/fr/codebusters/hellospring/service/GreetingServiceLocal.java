package fr.codebusters.hellospring.service;

import fr.codebusters.hellospring.entity.Greeting;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@Qualifier("greetingServiceLocal")
public class GreetingServiceLocal implements GreetingService{

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

    public void delete(Long id) {
        greetings.remove(id);
    }


    public Collection<Greeting> list(){
        return greetings.values();
    }

}
