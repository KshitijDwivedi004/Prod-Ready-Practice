package org.kshitij.prodreadyfeature.prodreadyfeature.advice;

import org.kshitij.prodreadyfeature.prodreadyfeature.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException e){
        ApiError apiError = ApiError.builder()
                .error(e.getLocalizedMessage())
                .status(HttpStatus.NOT_FOUND)
                .dateTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(apiError,apiError.getStatus());
    }
}
