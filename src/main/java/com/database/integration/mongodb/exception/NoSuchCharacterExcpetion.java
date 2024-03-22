package com.database.integration.mongodb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoSuchCharacterExcpetion extends RuntimeException {

    public NoSuchCharacterExcpetion(String message) {
        super(message);
    }
}
