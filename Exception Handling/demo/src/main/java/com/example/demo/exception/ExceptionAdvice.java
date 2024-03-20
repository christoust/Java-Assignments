package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = InvalidInputException.class)
    public ResponseEntity<CustomErrorResponse> handleGenericInvalidInputException(InvalidInputException e)
    {
        CustomErrorResponse errorResponse = new CustomErrorResponse("INVALID_INPUT_ERROR",e.getMessage());
        errorResponse.setTimeStamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }


}
