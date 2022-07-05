package com.storage.warehouse.errors.handlers;

import com.storage.warehouse.errors.StandardError;
import com.storage.warehouse.errors.ValidationError;
import com.storage.warehouse.errors.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> argumentFailedOnValidation(MethodArgumentNotValidException e, HttpServletRequest request){
        ValidationError error = new ValidationError();
        Integer statusCode = HttpStatus.UNPROCESSABLE_ENTITY.value();
        error.setTimestamp(Instant.now());
        error.setStatus(statusCode);
        error.setError("Parameter failed on validation");
        error.setMessage(e.getMessage()); // custom message from exception grabbed
        error.setPath(request.getRequestURI());

        for(FieldError fieldError: e.getBindingResult().getFieldErrors()){
            error.addErrorOnField(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(statusCode).body(error);
    }

}
