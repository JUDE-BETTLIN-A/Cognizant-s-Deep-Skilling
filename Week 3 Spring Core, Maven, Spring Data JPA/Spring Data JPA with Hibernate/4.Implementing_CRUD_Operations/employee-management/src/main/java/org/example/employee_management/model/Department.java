package org.example.employee_management.model;

import jakarta.persistence.*;

@Entity
public class Department {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public void setId(Long id) {
    }

    // Getters and setters
}
