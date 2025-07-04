package org.example.employee_management.runner;

import org.example.employee_management.model.Employee;
import org.example.employee_management.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryDemoRunner implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public QueryDemoRunner(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) {
        // Sample data
        employeeRepository.save(new Employee("Alice", "IT", 75000));
        employeeRepository.save(new Employee("Bob", "HR", 65000));
        employeeRepository.save(new Employee("Charlie", "IT", 85000));

        // Test queries
        System.out.println("Employees in IT:");
        employeeRepository.findByDepartment("IT").forEach(System.out::println);

        System.out.println("Employees with salary > 70000:");
        employeeRepository.findBySalaryGreaterThan(70000).forEach(System.out::println);

        System.out.println("Search by name containing 'li':");
        employeeRepository.findByNameContainingIgnoreCase("li").forEach(System.out::println);

        System.out.println("Rich employees in IT:");
        employeeRepository.findRichEmployeesInDept("IT", 80000).forEach(System.out::println);
    }
}
