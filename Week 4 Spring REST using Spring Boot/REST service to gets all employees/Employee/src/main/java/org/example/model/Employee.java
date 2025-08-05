package org.example.model;

import java.util.List;

public class Employee {
    private int id;
    private String name;
    private Department department;
    private List<String> skills;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills; }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' +
                ", department=" + department + ", skills=" + skills + '}';
    }
}
