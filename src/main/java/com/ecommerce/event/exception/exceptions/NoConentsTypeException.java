package com.ecommerce.event.exception.exceptions;

import org.springframework.http.HttpStatus;

public class NoConentsTypeException extends RuntimeException{
    private final HttpStatus status;
    private final String detail;

    public NoConentsTypeException(HttpStatus status, String detail) {
        this.status = status;
        this.detail = detail;
    }

    public NoConentsTypeException(String detail){
        this.status = HttpStatus.BAD_REQUEST;
        this.detail = detail;
    }
}
