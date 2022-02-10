package fr.codebusters.hellospring.service;

import fr.codebusters.hellospring.entity.PolitePerson;
import fr.codebusters.hellospring.exception.PolitePersonNotFoundException;
import fr.codebusters.hellospring.repository.GreetingRepository;
import fr.codebusters.hellospring.repository.PolitePersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
@Qualifier("politePersonRest")
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
        greetingRepository.saveAll(politePerson.getFavoriteGreetings());
        return politePersonRepository.save(politePerson);
    }

    @Override
    public void delete(Long id) {
        PolitePerson politePerson = read(id);
        greetingRepository.deleteAll(politePerson.getFavoriteGreetings());
        politePersonRepository.deleteById(id);
    }
}
