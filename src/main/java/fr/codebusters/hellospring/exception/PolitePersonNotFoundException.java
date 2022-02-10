package fr.codebusters.hellospring.exception;

public class PolitePersonNotFoundException extends RuntimeException{

    public PolitePersonNotFoundException(String message) {
        super(message);
    }
}
