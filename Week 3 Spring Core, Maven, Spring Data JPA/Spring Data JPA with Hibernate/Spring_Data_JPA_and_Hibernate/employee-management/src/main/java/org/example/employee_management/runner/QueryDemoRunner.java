package org.example.employee_management.runner;

import org.example.employee_management.model.Employee;
import org.example.employee_management.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemoRunner implements CommandLineRunner {

    private final EmployeeRepository repository;

    public QueryDemoRunner(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        repository.save(new Employee("Alice", "IT", 75000));
        repository.save(new Employee("Bob", "HR", 65000));
        repository.save(new Employee("Charlie", "IT", 85000));
        repository.save(new Employee("David", "Finance", 90000));

        System.out.println("All Employees:");
        repository.findAll().forEach(System.out::println);

        System.out.println("\nEmployees in IT:");
        repository.findByDepartment("IT").forEach(System.out::println);

        System.out.println("\nSalary > 70000:");
        repository.findBySalaryGreaterThan(70000).forEach(System.out::println);

        System.out.println("\nName contains 'li':");
        repository.searchByName("li").forEach(System.out::println);

        System.out.println("\nRich in IT:");
        repository.findRichEmployeesInDept("IT", 80000).forEach(System.out::println);
    }
}
