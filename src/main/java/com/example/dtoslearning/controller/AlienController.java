package com.example.dtoslearning.controller;

import com.example.dtoslearning.model.Aliens;
import com.example.dtoslearning.service.AlienServiceLayer;
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
    AlienServiceLayer alienServiceLayer;
    @Autowired
    EntityManager entityManager;

    @Transactional
    @PostMapping("/createAliensData")
    public ResponseEntity<String> createNewAlienAccount(@RequestBody Aliens aliens){
        entityManager.persist(aliens);
       return new ResponseEntity<>("Account created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Aliens getParticularAlienData(@PathVariable("id") Integer id){
        return alienServiceLayer.getParticularAlienData(id);
    }
}
