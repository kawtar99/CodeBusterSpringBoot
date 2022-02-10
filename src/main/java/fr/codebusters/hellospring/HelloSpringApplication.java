package fr.codebusters.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

	@PostConstruct
	public void sayHello(){
		System.out.println("Welcome to the Greeting application!");
	}

	@PreDestroy
	public void sayGoodBye(){
		System.out.println("The application stopped running. Goodbye!");
	}

}
