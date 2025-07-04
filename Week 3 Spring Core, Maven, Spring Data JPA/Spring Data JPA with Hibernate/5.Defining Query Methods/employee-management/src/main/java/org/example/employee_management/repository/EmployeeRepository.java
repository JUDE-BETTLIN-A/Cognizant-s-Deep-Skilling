package org.example.employee_management.repository;

import org.example.employee_management.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    // --- Query Methods by naming convention ---
    List<Employee> findByDepartment(String department);
    List<Employee> findBySalaryGreaterThan(double salary);
    List<Employee> findByNameContainingIgnoreCase(String namePart);

    // --- Custom JPQL queries using @Query annotation ---
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    List<Employee> searchByName(@Param("name") String name);

    @Query("SELECT e FROM Employee e WHERE e.department = :dept AND e.salary > :minSalary")
    List<Employee> findRichEmployeesInDept(@Param("dept") String dept, @Param("minSalary") double minSalary);
}
