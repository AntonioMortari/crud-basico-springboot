package com.api.crud.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
    
    private String message;
    private Instant timestamp;
    private HttpStatus statusCode;
    
    public ErrorMessage(String message, Instant timestamp, HttpStatus statusCode){
        this.message = message;
        this.timestamp = timestamp;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    

}
