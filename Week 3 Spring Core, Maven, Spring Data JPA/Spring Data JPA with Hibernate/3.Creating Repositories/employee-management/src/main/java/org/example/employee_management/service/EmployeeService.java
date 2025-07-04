package org.example.employee_management.service;

import org.example.employee_management.entity.Employee;
import org.example.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // CRUD Operations
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Custom business methods
    public Optional<Employee> findEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public List<Employee> findEmployeesByDepartment(Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    public List<Employee> findEmployeesByJobTitle(String jobTitle) {
        return employeeRepository.findByJobTitle(jobTitle);
    }

    public List<Employee> findEmployeesBySalaryRange(BigDecimal minSalary, BigDecimal maxSalary) {
        return employeeRepository.findBySalaryBetween(minSalary, maxSalary);
    }

    public List<Employee> findHighEarners(BigDecimal threshold) {
        return employeeRepository.findBySalaryGreaterThan(threshold);
    }

    public List<Employee> findActiveEmployees() {
        return employeeRepository.findByIsActiveTrue();
    }

    public List<Employee> findInactiveEmployees() {
        return employeeRepository.findByIsActiveFalse();
    }

    public List<Employee> findRecentHires(LocalDate sinceDate) {
        return employeeRepository.findByHireDateAfter(sinceDate);
    }

    public List<Employee> searchEmployees(String keyword) {
        return employeeRepository.searchEmployees(keyword);
    }

    public Optional<Employee> findEmployeeWithDepartment(Long id) {
        return employeeRepository.findByIdWithDepartment(id);
    }

    public List<Employee> findEmployeesHiredBetweenDates(LocalDate startDate, LocalDate endDate) {
        return employeeRepository.findEmployeesHiredBetweenDates(startDate, endDate);
    }

    public List<Employee> findTopEarners(BigDecimal minSalary, int limit) {
        return employeeRepository.findTopEmployeesBySalary(minSalary, limit);
    }

    // Statistical methods
    public BigDecimal getAverageSalaryByDepartment(Long departmentId) {
        return employeeRepository.findAverageSalaryByDepartmentId(departmentId);
    }

    public BigDecimal getMaxSalaryByDepartment(Long departmentId) {
        return employeeRepository.findMaxSalaryByDepartmentId(departmentId);
    }

    public BigDecimal getMinSalaryByDepartment(Long departmentId) {
        return employeeRepository.findMinSalaryByDepartmentId(departmentId);
    }

    public long countActiveEmployeesByDepartment(Long departmentId) {
        return employeeRepository.countActiveEmployeesByDepartmentId(departmentId);
    }

    public long countTotalActiveEmployees() {
        return employeeRepository.countByIsActiveTrue();
    }

    public boolean isEmailTaken(String email) {
        return employeeRepository.existsByEmail(email);
    }

    // Employee status management
    public Employee activateEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employee.get().setIsActive(true);
            return employeeRepository.save(employee.get());
        }
        return null;
    }

    public Employee deactivateEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employee.get().setIsActive(false);
            return employeeRepository.save(employee.get());
        }
        return null;
    }

    public void cleanupInactiveEmployees() {
        employeeRepository.deleteByIsActiveFalse();
    }
}