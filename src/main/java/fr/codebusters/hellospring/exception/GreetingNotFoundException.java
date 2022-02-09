package fr.codebusters.hellospring.exception;

public class GreetingNotFoundException extends RuntimeException{

    public GreetingNotFoundException(String msg){
        super(msg);
    }
}
