package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

//    private EmployeeRepo employeeRepo;


    public List<Employee> fetchAllEmployee() {
        List<Employee> employeeList= new ArrayList<>();
        employeeList.add(new Employee(1,"John"));
        employeeList.add(new Employee(2,"Ram"));
        return employeeList;
    }

    public Employee fetchEmployeeById(String id) {
        return new Employee(1, "King");
    }
}
