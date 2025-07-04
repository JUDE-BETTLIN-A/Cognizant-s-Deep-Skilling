package org.example.employee_management.controller;

import org.example.employee_management.entity.Department;
import org.example.employee_management.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentRepository departmentRepo;

    public DepartmentController(DepartmentRepository departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @GetMapping
    public List<Department> getAll() {
        return departmentRepo.findAll();
    }

    @PostMapping
    public Department add(@RequestBody Department department) {
        return departmentRepo.save(department);
    }
}
