package com.example.orm_learn.Repository;

import com.example.orm_learn.Entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
