package com.example.Immigration_Management_System_Demo.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ErrorResponse {
    public ErrorResponse(Date timestamp, int statusCode, HttpStatus status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    private Date timestamp;
    private int statusCode;
    private HttpStatus status;
    private String error;
    private String message;
    private String path;

}
