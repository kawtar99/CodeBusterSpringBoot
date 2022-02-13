# CodeBusterSpringBoot
***

CodeBusterSpringBoot Project is an introduction project to Spring Boot. The aim of this project is to test the Spring Boot framework and explore some of its features.
The project revolves around polites persons and the greeting expressions they use.

# Project Dependencies
Here is a list of dependencies used for the project:
* [Java](https://www.java.com/fr/): Version 17
* [Apache Maven](https://maven.apache.org/) : Version 3.8.3
* [Spring Boot](https://spring.io/projects/spring-boot) : Version 2.6.2
* [JUnit](https://junit.org/junit5) : Version JUnit 5 tu run tests
* [H2 Database](http://h2database.com/html/main.html) : we use in-memory database for this project

# Project Architecture

This project is a **RESTFul** application. The source classes are located in the `src/test/java/fr/codebusters/hellospring/` folder. 
This folder contains various packages that structure the project architecture:
* **entity** : contains POJO objects that encapsulate the Data Structures used for the project. These Data Structures are:
    * Greeting : A Greeting is a polite expression said to greet someone. This structure has a unique id and a string message.
    * PolitePerson : A PolitePerson is someone who uses greetings. This structure has a unique id and a set of favorite Greetings
* **repository** : contains repository interfaces. These interfaces define the way we would like to stock the data. For this project, all the repositories extend **JPARepository**.
* **sercive** : groups the services classes. Contains all the business logic related to CRUD operations on the entities.
* **controller** : This package contains all the controller classes. Since the application is RESTful, the Controllers used are annotated with **@RestController**
* **exception** : defines exception related to unwanted scenario cases, as if a Greeting is not found, and the correct way to handle it using a **@ControllerAdvise**


# Features

## Data Structures 

## EndPoints

# Progress
