package org.example.EmployeeManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    // Many employees belong to one department
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
