package com.re.controller;

import com.re.model.Employee;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employee-list")
public class EmployeeController {
    @GetMapping
    public String getEmployee(HttpServletRequest servlet) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Nguyen Van A", "IT", 15000.0));
        employees.add(new Employee(2, "Tran Thi B", "Marketing", 1200.0));
        employees.add(new Employee(3, "Le Van C", "HR", 1000.0));
        servlet.setAttribute("employees",employees);
        return "employee-list";
    }
}

