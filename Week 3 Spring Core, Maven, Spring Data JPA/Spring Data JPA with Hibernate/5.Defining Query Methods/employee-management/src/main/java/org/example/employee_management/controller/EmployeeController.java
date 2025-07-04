package org.example.employee_management.controller;

import org.example.employee_management.entity.Employee;
import org.example.employee_management.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepo;

    public EmployeeController(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping("/by-name/{name}")
    public List<Employee> getByName(@PathVariable String name) {
        return employeeRepo.findByName(name);
    }

    @GetMapping("/by-domain/{domain}")
    public List<Employee> getByDomain(@PathVariable String domain) {
        return employeeRepo.findByEmailDomain(domain);
    }

    @GetMapping("/by-department/{deptName}")
    public List<Employee> getByDepartment(@PathVariable String deptName) {
        return employeeRepo.findByDepartmentName(deptName);
    }
}
