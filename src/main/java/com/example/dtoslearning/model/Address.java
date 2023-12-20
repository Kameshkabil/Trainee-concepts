package com.example.dtoslearning.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ADDRESS_INFO")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "address")
    private String empAddress;

    @OneToOne
    private Employee employee;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return empAddress;
    }

    public void setAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
