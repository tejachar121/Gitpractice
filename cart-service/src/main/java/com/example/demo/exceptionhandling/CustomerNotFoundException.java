package com.example.demo.exceptionhandling;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(String message) {
		super(message);
	}

}
