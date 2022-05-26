package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/wish")
    public String sayHello() {
        return "Welcome Spring Boot Security";
    }

    @RequestMapping("/fetchall")
    public List<Employee> fetchAllEmployee() {

        return employeeService.fetchAllEmployee();
    }

    @RequestMapping("/fetch/{id}")
    public Employee fetEmployee(@PathVariable String id) {
        return employeeService.fetchEmployeeById(id);
    }


    @RequestMapping("/save")
    public String saveEmployee() {
        return "Save completed";
    }
}
