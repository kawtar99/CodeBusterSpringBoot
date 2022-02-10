package fr.codebusters.hellospring.service;

import fr.codebusters.hellospring.entity.PolitePerson;
import fr.codebusters.hellospring.exception.PolitePersonNotFoundException;
import fr.codebusters.hellospring.repository.GreetingRepository;
import fr.codebusters.hellospring.repository.PolitePersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PolitePersonImpl implements PolitePersonService{

    private PolitePersonRepository politePersonRepository;
    private GreetingRepository greetingRepository;

    @Autowired
    public PolitePersonImpl(PolitePersonRepository politePersonRepository, GreetingRepository greetingRepository) {
        this.politePersonRepository = politePersonRepository;
        this.greetingRepository = greetingRepository;
    }

    @Override
    public PolitePerson read(Long id) {
        return politePersonRepository.findById(id)
                .orElseThrow(() -> new PolitePersonNotFoundException("Person with id "+ id +" is not found"));
    }

    @Override
    public PolitePerson save(PolitePerson politePerson) {

        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
