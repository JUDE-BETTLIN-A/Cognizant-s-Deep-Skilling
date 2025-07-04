package org.example.employee_management.service;

import org.example.employee_management.entity.Department;
import org.example.employee_management.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // CRUD Operations
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> findDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    // Custom business methods
    public Optional<Department> findDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }

    public List<Department> findDepartmentsByLocation(String location) {
        return departmentRepository.findByLocation(location);
    }

    public List<Department> findDepartmentsByBudgetRange(Double minBudget, Double maxBudget) {
        return departmentRepository.findByBudgetBetween(minBudget, maxBudget);
    }

    public List<Department> findDepartmentsWithHighBudget(Double threshold) {
        return departmentRepository.findByBudgetGreaterThan(threshold);
    }

    public List<Department> searchDepartmentsByName(String keyword) {
        return departmentRepository.findByNameContainingIgnoreCase(keyword);
    }

    public Optional<Department> findDepartmentWithEmployees(Long id) {
        return departmentRepository.findByIdWithEmployees(id);
    }

    public List<Department> findDepartmentsWithManyEmployees(int minEmployeeCount) {
        return departmentRepository.findDepartmentsWithMoreThanXEmployees(minEmployeeCount);
    }

    public List<Department> findEmptyDepartments() {
        return departmentRepository.findDepartmentsWithNoEmployees();
    }

    public boolean isDepartmentNameTaken(String name) {
        return departmentRepository.existsByName(name);
    }

    public long countDepartmentsByLocation(String location) {
        return departmentRepository.countByLocation(location);
    }
}