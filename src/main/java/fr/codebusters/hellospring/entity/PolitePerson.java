package fr.codebusters.hellospring.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PolitePerson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private Set<Greeting> favoriteGreetings;

    public PolitePerson(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Greeting> getFavoriteGreetings() {
        return favoriteGreetings;
    }

    public void setFavoriteGreetings(Set<Greeting> favoriteGreetings) {
        this.favoriteGreetings = favoriteGreetings;
    }
}
