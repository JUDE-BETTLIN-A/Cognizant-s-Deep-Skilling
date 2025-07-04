package org.example.employee_management.controller;

import org.example.employee_management.entity.Employee;
import org.example.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create Employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        if (employeeService.isEmailTaken(employee.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    // Get All Employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findEmployeeById(id);
        return employee.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get Employee with Department
    @GetMapping("/{id}/with-department")
    public ResponseEntity<Employee> getEmployeeWithDepartment(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findEmployeeWithDepartment(id);
        return employee.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @Valid @RequestBody Employee employee) {
        Optional<Employee> existingEmployee = employeeService.findEmployeeById(id);
        if (existingEmployee.isPresent()) {
            employee.setId(id);
            Employee updatedEmployee = employeeService.updateEmployee(employee);
            return ResponseEntity.ok(updatedEmployee);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findEmployeeById(id);
        if (employee.isPresent()) {
            employeeService.deleteEmployee(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Search Employees
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployees(@RequestParam String keyword) {
        List<Employee> employees = employeeService.searchEmployees(keyword);
        return ResponseEntity.ok(employees);
    }

    // Get Employee by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable String email) {
        Optional<Employee> employee = employeeService.findEmployeeByEmail(email);
        return employee.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get Employees by Department
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable Long departmentId) {
        List<Employee> employees = employeeService.findEmployeesByDepartment(departmentId);
        return ResponseEntity.ok(employees);
    }

    // Get Employees by Job Title
    @GetMapping("/job-title/{jobTitle}")
    public ResponseEntity<List<Employee>> getEmployeesByJobTitle(@PathVariable String jobTitle) {
        List<Employee> employees = employeeService.findEmployeesByJobTitle(jobTitle);
        return ResponseEntity.ok(employees);
    }

    // Get Employees by Salary Range
    @GetMapping("/salary-range")
    public ResponseEntity<List<Employee>> getEmployeesBySalaryRange(
            @RequestParam BigDecimal minSalary,
            @RequestParam BigDecimal maxSalary) {
        List<Employee> employees = employeeService.findEmployeesBySalaryRange(minSalary, maxSalary);
        return ResponseEntity.ok(employees);
    }

    // Get High Earners
    @GetMapping("/high-earners")
    public ResponseEntity<List<Employee>> getHighEarners(@RequestParam BigDecimal threshold) {
        List<Employee> employees = employeeService.findHighEarners(threshold);
        return ResponseEntity.ok(employees);
    }

    // Get Active Employees
    @GetMapping("/active")
    public ResponseEntity<List<Employee>> getActiveEmployees() {
        List<Employee> employees = employeeService.findActiveEmployees();
        return ResponseEntity.ok(employees);
    }

    // Get Inactive Employees
    @GetMapping("/inactive")
    public ResponseEntity<List<Employee>> getInactiveEmployees() {
        List<Employee> employees = employeeService.findInactiveEmployees();
        return ResponseEntity.ok(employees);
    }

    // Get Recent Hires
    @GetMapping("/recent-hires")
    public ResponseEntity<List<Employee>> getRecentHires(@RequestParam String sinceDate) {
        LocalDate date = LocalDate.parse(sinceDate);
        List<Employee> employees = employeeService.findRecentHires(date);
        return ResponseEntity.ok(employees);
    }

    // Get Employees Hired Between Dates
    @GetMapping("/hired-between")
    public ResponseEntity<List<Employee>> getEmployeesHiredBetweenDates(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<Employee> employees = employeeService.findEmployeesHiredBetweenDates(start, end);
        return ResponseEntity.ok(employees);
    }

    // Get Top Earners
    @GetMapping("/top-earners")
    public ResponseEntity<List<Employee>> getTopEarners(
            @RequestParam BigDecimal minSalary,
            @RequestParam int limit) {
        List<Employee> employees = employeeService.findTopEarners(minSalary, limit);
        return ResponseEntity.ok(employees);
    }

    // Statistical Endpoints
    @GetMapping("/statistics/average-salary/department/{departmentId}")
    public ResponseEntity<BigDecimal> getAverageSalaryByDepartment(@PathVariable Long departmentId) {
        BigDecimal averageSalary = employeeService.getAverageSalaryByDepartment(departmentId);
        return ResponseEntity.ok(averageSalary);
    }

    @GetMapping("/statistics/max-salary/department/{departmentId}")
    public ResponseEntity<BigDecimal> getMaxSalaryByDepartment(@PathVariable Long departmentId) {
        BigDecimal maxSalary = employeeService.getMaxSalaryByDepartment(departmentId);
        return ResponseEntity.ok(maxSalary);
    }

    @GetMapping("/statistics/min-salary/department/{departmentId}")
    public ResponseEntity<BigDecimal> getMinSalaryByDepartment(@PathVariable Long departmentId) {
        BigDecimal minSalary = employeeService.getMinSalaryByDepartment(departmentId);
        return ResponseEntity.ok(minSalary);
    }

    @GetMapping("/statistics/count/active/department/{departmentId}")
    public ResponseEntity<Long> countActiveEmployeesByDepartment(@PathVariable Long departmentId) {
        long count = employeeService.countActiveEmployeesByDepartment(departmentId);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/statistics/count/active")
    public ResponseEntity<Long> countTotalActiveEmployees() {
        long count = employeeService.countTotalActiveEmployees();
        return ResponseEntity.ok(count);
    }

    // Employee Status Management
    @PutMapping("/{id}/activate")
    public ResponseEntity<Employee> activateEmployee(@PathVariable Long id) {
        Employee employee = employeeService.activateEmployee(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Employee> deactivateEmployee(@PathVariable Long id) {
        Employee employee = employeeService.deactivateEmployee(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/cleanup-inactive")
    public ResponseEntity<Void> cleanupInactiveEmployees() {
        employeeService.cleanupInactiveEmployees();
        return ResponseEntity.noContent().build();
    }
}