package com.example.dtoslearning.service;


import com.example.dtoslearning.model.Address;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class AddressService {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public void addAddress(Address address){
        entityManager.persist(address);
    }
}
