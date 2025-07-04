package org.example.employee_management.controller;

import org.example.employee_management.entity.Department;
import org.example.employee_management.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "*")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Create Department
    @PostMapping
    public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department department) {
        if (departmentService.isDepartmentNameTaken(department.getName())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Department savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
    }

    // Get All Departments
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.findAllDepartments();
        return ResponseEntity.ok(departments);
    }

    // Get Department by ID
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Optional<Department> department = departmentService.findDepartmentById(id);
        return department.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get Department with Employees
    @GetMapping("/{id}/with-employees")
    public ResponseEntity<Department> getDepartmentWithEmployees(@PathVariable Long id) {
        Optional<Department> department = departmentService.findDepartmentWithEmployees(id);
        return department.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update Department
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id,
                                                       @Valid @RequestBody Department department) {
        Optional<Department> existingDepartment = departmentService.findDepartmentById(id);
        if (existingDepartment.isPresent()) {
            department.setId(id);
            Department updatedDepartment = departmentService.updateDepartment(department);
            return ResponseEntity.ok(updatedDepartment);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete Department
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        Optional<Department> department = departmentService.findDepartmentById(id);
        if (department.isPresent()) {
            departmentService.deleteDepartment(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Search Departments by Name
    @GetMapping("/search")
    public ResponseEntity<List<Department>> searchDepartmentsByName(@RequestParam String name) {
        List<Department> departments = departmentService.searchDepartmentsByName(name);
        return ResponseEntity.ok(departments);
    }

    // Get Departments by Location
    @GetMapping("/location/{location}")
    public ResponseEntity<List<Department>> getDepartmentsByLocation(@PathVariable String location) {
        List<Department> departments = departmentService.findDepartmentsByLocation(location);
        return ResponseEntity.ok(departments);
    }

    // Get Departments by Budget Range
    @GetMapping("/budget-range")
    public ResponseEntity<List<Department>> getDepartmentsByBudgetRange(
            @RequestParam Double minBudget,
            @RequestParam Double maxBudget) {
        List<Department> departments = departmentService.findDepartmentsByBudgetRange(minBudget, maxBudget);
        return ResponseEntity.ok(departments);
    }

    // Get High Budget Departments
    @GetMapping("/high-budget")
    public ResponseEntity<List<Department>> getHighBudgetDepartments(@RequestParam Double threshold) {
        List<Department> departments = departmentService.findDepartmentsWithHighBudget(threshold);
        return ResponseEntity.ok(departments);
    }

    // Get Departments with Many Employees
    @GetMapping("/many-employees")
    public ResponseEntity<List<Department>> getDepartmentsWithManyEmployees(@RequestParam int minCount) {
        List<Department> departments = departmentService.findDepartmentsWithManyEmployees(minCount);
        return ResponseEntity.ok(departments);
    }

    // Get Empty Departments
    @GetMapping("/empty")
    public ResponseEntity<List<Department>> getEmptyDepartments() {
        List<Department> departments = departmentService.findEmptyDepartments();
        return ResponseEntity.ok(departments);
    }

    // Count Departments by Location
    @GetMapping("/count/location/{location}")
    public ResponseEntity<Long> countDepartmentsByLocation(@PathVariable String location) {
        long count = departmentService.countDepartmentsByLocation(location);
        return ResponseEntity.ok(count);
    }
}