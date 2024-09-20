package com.ecommerce.event.exception;


import com.ecommerce.event.exception.exceptions.NoConentsTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(NoConentsTypeException.class)
    public ResponseEntity handleFileException(NoConentsTypeException e) {
        return ResponseEntity.badRequest().build();
    }
}
