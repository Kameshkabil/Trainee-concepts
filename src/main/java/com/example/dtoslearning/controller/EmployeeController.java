package com.example.dtoslearning.controller;


import com.example.dtoslearning.model.Employee;
import com.example.dtoslearning.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<String> addEmployeeRecords(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return new ResponseEntity<>("added successfully", HttpStatus.CREATED);
    }
}
