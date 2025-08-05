package org.example;

import org.example.dao.EmployeeDao;
import org.example.model.Employee;

public class App {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        for (Employee e : dao.getAllEmployees()) {
            System.out.println(e);
        }
    }
}
