package com.example.dtoslearning.controller;

import com.example.dtoslearning.model.Aliens;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aliens")
public class AlienController {

    @Autowired
    EntityManager entityManager;

    @Transactional
    @PostMapping("/createAliensData")
    public ResponseEntity<String> createNewAlienAccount(@RequestBody Aliens aliens){
        entityManager.persist(aliens);
       return new ResponseEntity<>("Account created successfully", HttpStatus.CREATED);
    }
}
