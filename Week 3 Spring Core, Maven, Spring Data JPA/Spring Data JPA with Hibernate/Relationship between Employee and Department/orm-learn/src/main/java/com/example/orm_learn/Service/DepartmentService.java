package com.example.orm_learn.Service;

import com.example.orm_learn.Entity.Department;
import com.example.orm_learn.Repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository repo;

    public DepartmentService(DepartmentRepository repo) {
        this.repo = repo;
    }

    public Department get(Long id) {
        Optional<Department> optional = repo.findById(id);
        return optional.orElse(null);
    }
}
