package com.example.springbootAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) //que no se ha podido encontrar algo
public class FileNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1l;

    public FileNotFoundException(String mensaje) {
        super(mensaje);
    }
}