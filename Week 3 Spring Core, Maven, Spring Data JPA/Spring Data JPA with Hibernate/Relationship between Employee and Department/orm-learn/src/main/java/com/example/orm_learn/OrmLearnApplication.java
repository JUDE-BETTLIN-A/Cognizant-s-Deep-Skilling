package com.example.orm_learn;

import com.example.orm_learn.Entity.Department;
import com.example.orm_learn.Entity.Employee;
import com.example.orm_learn.Service.DepartmentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrmLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DepartmentService departmentService) {
		return args -> {
			testGetDepartment(departmentService); // ✅ invoke only this
		};
	}

	public void testGetDepartment(DepartmentService departmentService) {
		Department dept = departmentService.get(1L); // Pick an ID that exists and has employees
		System.out.println("Department: " + dept);

		// LazyInitializationException will occur here if not fetched eagerly
		System.out.println("Employees:");
		for (Employee emp : dept.getEmployeeList()) {
			System.out.println(emp);
		}
	}
}
