package com.example.demo.exceptionhandling;

public class ProductNotFoundException extends RuntimeException {

public ProductNotFoundException(String message) {
        super(message);
    }

}
