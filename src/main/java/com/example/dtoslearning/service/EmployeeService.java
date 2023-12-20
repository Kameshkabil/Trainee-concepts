package com.example.dtoslearning.service;


import com.example.dtoslearning.model.Address;
import com.example.dtoslearning.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class EmployeeService {
    @Autowired
    EntityManager entityManager;

    @Autowired
    AddressService addressService;

    @Transactional
    public void addEmployee(Employee employee){
        entityManager.persist(employee);
        Address address = null;
        address.setId(123L);
        address.setAddress("varanasi");
        address.setEmployee(employee);
        addressService.addAddress(address);
    }
}
