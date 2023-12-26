package com.example.dtoslearning.service;


import com.example.dtoslearning.model.Aliens;
//import com.example.dtoslearning.repository.AlienRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlienServiceLayer {

    @Autowired
    EntityManager entityManager;
   // @Autowired
//    AlienRepository alienRepository;
//
//    public List<Aliens> getAllAliens(){
//        return alienRepository.findAll();
//    }


    public Aliens getParticularAlienData(Integer id){
        String jpql = "SELECT a FROM Aliens a WHERE a.alienId= :id";
        return (Aliens) entityManager.createQuery(jpql,Aliens.class)
                .setParameter("id",id)
                .getSingleResult();
    }


}
