package com.thewhiterabbits.articleservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClothingNotFoundException extends RuntimeException {
    public ClothingNotFoundException(String message) {
        super(message);
    }
}
