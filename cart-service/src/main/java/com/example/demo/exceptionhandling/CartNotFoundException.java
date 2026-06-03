package com.example.demo.exceptionhandling;

public class CartNotFoundException extends RuntimeException{

public CartNotFoundException(String message) {
        super(message);
    }

}
