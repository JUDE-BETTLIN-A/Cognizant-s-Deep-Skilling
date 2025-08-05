package org.example.dao;

import org.example.model.Department;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DepartmentDao {
    public static List<Department> DEPARTMENT_LIST;

    public DepartmentDao() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("department.xml");
        DEPARTMENT_LIST = (List<Department>) context.getBean("departmentList");
        context.close();
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
