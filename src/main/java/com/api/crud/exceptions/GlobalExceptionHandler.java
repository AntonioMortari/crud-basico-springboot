package com.api.crud.exceptions;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> notFoundException(NotFoundException ex){
        ErrorMessage errorMessage = new ErrorMessage(
            ex.getMessage(), 
            Instant.now(), 
            404);
        return ResponseEntity.status(404).body(errorMessage);
    }

}
