package com.example.dtoslearning.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<Object> handleException(IllegalArgumentException e){
//        return new ResponseEntity<Object>("Account Already Exists", HttpStatus.CONFLICT);
//    }
//}
