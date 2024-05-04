package com.example.springbootAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<String> handleRecursoNoEncontrado(FileNotFoundException ex) {
        String mensaje = ex.getMessage();
        return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
    }
}