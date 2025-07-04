package org.example.employee_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
		System.out.println("Employee Management System is running!");
		System.out.println("H2 Console: http://localhost:8080/h2-console");
		System.out.println("API Base URL: http://localhost:8080/api");
	}
}