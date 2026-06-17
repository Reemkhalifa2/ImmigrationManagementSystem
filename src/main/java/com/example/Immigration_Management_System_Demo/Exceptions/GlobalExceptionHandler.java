package com.example.Immigration_Management_System_Demo.Exceptions;

import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(GenericException ex , WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(
                new Date(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND ,
                "Resource Not Found",
                ex.getMessage(),
                request.getDescription(false).replace("uri",""));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }


    @ExceptionHandler(GenericException.class)
    public ResponseEntity<String> notFound(GenericException ex){
        return ResponseEntity
                .status(404)
                .body(ex.getMessage());
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> runtime(RuntimeException ex){
        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> illegal(IllegalArgumentException ex){
        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> general(Exception ex){
        return ResponseEntity
                .status(500)
                .body("Unexpected error occurred");
    }





}
