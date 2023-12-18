package com.example.dtoslearning.exceptionHandler;

import com.example.dtoslearning.exceptions.ProductNotFoundException;
import com.example.dtoslearning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<Object> handleException(IllegalArgumentException e){
//        return new ResponseEntity<Object>("This Product Not Available 😒", HttpStatus.NOT_FOUND);
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductNotFoundException.class)
    public Map<String,String> handleProductNotFound(ProductNotFoundException e){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("error Message",e.getMessage());
        return errorMap;
    }


}
