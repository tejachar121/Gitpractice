package com.example.demo.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerException(CustomerNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


@ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductException(ProductNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }



@ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<String> handleCartException(CartNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }



@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneric(Exception ex) {
        return new ResponseEntity<>("Something went wrong: " + ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }


	

}
