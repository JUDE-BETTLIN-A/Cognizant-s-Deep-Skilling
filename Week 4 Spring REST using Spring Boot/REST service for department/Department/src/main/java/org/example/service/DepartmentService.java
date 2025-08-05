package org.example.service;

import org.example.dao.DepartmentDao;
import org.example.model.Department;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentDao dao = new DepartmentDao();

    @Transactional
    public List<Department> getAllDepartments() {
        return dao.getAllDepartments();
    }
}
