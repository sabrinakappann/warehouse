package com.storage.warehouse.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request){
        StandardError error = new StandardError();
        Integer statusCode = HttpStatus.NOT_FOUND.value();
        error.setTimestamp(Instant.now());
        error.setStatus(statusCode);
        error.setError("Resource not found");
        error.setMessage(e.getMessage()); // custom message from exception grabbed
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(statusCode).body(error);
    }

}
