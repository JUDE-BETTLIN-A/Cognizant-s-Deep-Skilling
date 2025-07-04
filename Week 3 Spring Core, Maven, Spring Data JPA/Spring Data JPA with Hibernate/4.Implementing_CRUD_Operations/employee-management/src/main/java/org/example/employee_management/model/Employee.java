package org.example.employee_management.model;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public void setId(Long id) {
    }

    // Getters and setters
}
