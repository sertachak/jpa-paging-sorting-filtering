package com.sha.jpapagingsortingfiltering.controller;

import com.sha.jpapagingsortingfiltering.dto.APIResponse;
import com.sha.jpapagingsortingfiltering.model.Employee;
import com.sha.jpapagingsortingfiltering.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public APIResponse<List<Employee>> getEmployees() {
        List<Employee> employeeList = employeeService.findAll();
        return new APIResponse<>(employeeList.size(), employeeList);
    }
}
