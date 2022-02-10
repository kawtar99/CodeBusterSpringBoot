package fr.codebusters.hellospring.service;

import fr.codebusters.hellospring.entity.PolitePerson;

public interface PolitePersonService {

    public PolitePerson read(Long id);

    public PolitePerson save(PolitePerson politePerson);

    public void delete(Long id);
}
