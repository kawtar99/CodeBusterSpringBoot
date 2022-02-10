package fr.codebusters.hellospring.repository;

import fr.codebusters.hellospring.entity.Greeting;
import fr.codebusters.hellospring.entity.PolitePerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PolitePersonRepository extends JpaRepository<PolitePerson, Long> {

}
