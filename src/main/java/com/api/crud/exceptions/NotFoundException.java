package com.api.crud.exceptions;

import java.lang.RuntimeException;

public class NotFoundException extends RuntimeException {
    
    public NotFoundException(String message){
        super(message);
    }

}
