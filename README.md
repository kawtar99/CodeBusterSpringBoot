# CodeBusterSpringBoot
***

CodeBusterSpringBoot Project is an introduction project to Spring Boot. The aim of this project is to test the Spring Boot framework and explore some of its features.
The project revolves around polite persons and the greeting expressions they use.

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

This application defines different endpoints that enable the user to read, retrieve, and delete information about greetings. These operations are made possible by **HTTP Requests** using these **URLs**:

* **Creating a Greeting** : We can create a Greeting object Using the **POST** method with the following URL : `localhost:8080/greetings/`. This is the result of the request on Postman. The request body is a **JSON** object with **message** field specified. The id is generated automatically by the program.

<img width="623" alt="Post_Greeting" src="https://user-images.githubusercontent.com/59917018/153766859-a6dfcbab-d419-4bd2-b563-fd6da58d1320.PNG">

* **Reading a Greeting** : We can read a Greeting object Using the **GET** method with the following URL : `localhost:8080/greetings/{id}`. The `id` parameter is the id of the greeting we want to read. The response body is a **JSON** object.


<img width="631" alt="Get_Greeting" src="https://user-images.githubusercontent.com/59917018/153766993-c9019910-0512-43c8-9d22-591fdb433f5a.PNG">

* **Listing all greetings** : All Greeting objects can be listed using the method **GET** the Url: `localhost:8080/greetings/`:

<img width="631" alt="List_greetings" src="https://user-images.githubusercontent.com/59917018/153767167-dc2e0ef6-1f6f-4c08-baf5-09de6b4e02ef.PNG">


* **Deleting a Greeting** : A Greeting object can also be deleted using the **Delete** method and the Url : `localhost:8080/greetings/{id}`. This method takes no request body and has no response body.

# Progress
* The Application follows a Spring Boot RestFul application Layout: classes annotated with **@RestController**, **@Service**, **@Entity**
* The Repository used to store Greeting extends **JPARepository**
* The return type of methods in the controller class is **ResponseEntity**<**Greeting**>. This structure allows to return the object and specify a HTTP status.
* The exceptions are handled in a class annotated with **@ControllerAdvice** 
