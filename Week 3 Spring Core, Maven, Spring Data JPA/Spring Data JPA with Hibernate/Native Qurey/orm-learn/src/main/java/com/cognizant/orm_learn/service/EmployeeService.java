package com.cognizant.orm_learn.service;


import com.cognizant.orm_learn.entity.Employee;
import com.cognizant.orm_learn.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAllEmployees() {
        return repo.getAllEmployeesNative();
    }
}