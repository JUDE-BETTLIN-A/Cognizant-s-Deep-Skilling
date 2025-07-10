package com.cognizant.Employee_service.controller;


import com.cognizant.Employee_service.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
    List<Employee> employeeList = (List<Employee>) context.getBean("employeeList");

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
