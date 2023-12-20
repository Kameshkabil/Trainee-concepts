package com.example.dtoslearning.controller;

import com.example.dtoslearning.model.UserRestTemp;
import com.example.dtoslearning.service.RestTemplateServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTemplateController {
    @Autowired
    RestTemplateServiceLayer restTemplateServiceLayer;

    @GetMapping("/")
    public ResponseEntity<UserRestTemp> getData(){
        return new ResponseEntity<>(restTemplateServiceLayer.consumeApi(), HttpStatus.OK);

    }
}
