package com.example.Immigration_Management_System_Demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ApplicantException extends RuntimeException{
    private final HttpStatus status;

    public ApplicantException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ApplicantException(HttpStatus status,String message) {
        super(message);
        this.status = status;
    }

    public static ApplicantException notFound(Integer id) {
        return new ApplicantException(HttpStatus.NOT_FOUND,"Course with ID " + id + " was not found.");
    }
    public static ApplicantException badRequest(String message) {
        return new ApplicantException(HttpStatus.BAD_REQUEST, message);
    }

    public HttpStatus getStatus() {
        return status;
    }
}
