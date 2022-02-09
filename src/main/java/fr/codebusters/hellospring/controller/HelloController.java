package fr.codebusters.hellospring.controller;


import fr.codebusters.hellospring.entity.Greeting;
import fr.codebusters.hellospring.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class HelloController {

    private GreetingService greetingService;

    @Autowired
    public HelloController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @GetMapping("/")
    public String home(){
        return "Hello Spring Boot!";
    }


    @GetMapping(value = "/greetings")
    public Collection<Greeting> list(){
        return greetingService.list();
    }

    @GetMapping(value = "/greetings/{id}")
    public ResponseEntity<Greeting> read(@PathVariable(value = "id") Long id){
        Greeting greeting = greetingService.read(id);
        return (greeting == null)? ResponseEntity.notFound().build() : ResponseEntity.ok(greeting);
    }

    @PostMapping(value = "/greetings/")
    public Greeting save(@RequestBody Greeting greeting){
        return greetingService.save(greeting);
    }

    @PutMapping(value = "/greetings/{id}")
    public void update(@PathVariable(value = "id") Long id, Greeting greeting){
        greetingService.save(greeting);
    }

}
