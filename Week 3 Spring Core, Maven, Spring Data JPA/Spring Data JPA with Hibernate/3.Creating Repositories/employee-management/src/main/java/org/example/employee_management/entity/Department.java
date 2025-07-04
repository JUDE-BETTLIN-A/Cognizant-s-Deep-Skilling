package org.example.employee_management.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Constructors, getters, setters
    public Department() {}

    public Department(String name) {
        this.name = name;
    }

    // Getters and setters
    // ...
}
