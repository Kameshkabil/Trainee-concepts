package com.example.dtoslearning.controller;


import com.example.dtoslearning.model.Employee;
import com.example.dtoslearning.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Employee",description = "the Employee api")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;



    @Operation(
            summary = "Create Employee Information",
            description = "post entities and their data from data source"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "created successfully")
    })

    @PostMapping("/add")
    public ResponseEntity<String> addEmployeeRecords(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return new ResponseEntity<>("added successfully", HttpStatus.CREATED);
    }
}
