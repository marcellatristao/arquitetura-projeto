package com.spring_arquitetura.spring_arquitetura.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ErrorExcep extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ErrorExcep(String msg) {
        super(msg);
    }
}