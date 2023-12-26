package com.example.dtoslearning.service;


import com.example.dtoslearning.model.Aliens;
import com.example.dtoslearning.repository.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlienServiceLayer {
    @Autowired
    AlienRepository alienRepository;

    public List<Aliens> getAllAliens(){
        return alienRepository.findAll();
    }
}
