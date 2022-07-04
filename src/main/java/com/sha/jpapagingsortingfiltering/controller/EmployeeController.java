package com.sha.jpapagingsortingfiltering.controller;

import com.sha.jpapagingsortingfiltering.dto.APIResponse;
import com.sha.jpapagingsortingfiltering.model.Employee;
import com.sha.jpapagingsortingfiltering.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{field}")
    public APIResponse<List<Employee>> getEmployeesWithSorted(@PathVariable String field) {
        List<Employee> employeeList = employeeService.findEmployeesWithSorting(field );
        return new APIResponse<>(employeeList.size(), employeeList);
    }

    @GetMapping("/pagination/{offset}/{pagesize}")
    public APIResponse<Page<Employee>> getEmployeesWithSorting(@PathVariable Integer offset, @PathVariable Integer pageSize) {
        Page<Employee> employeeList = employeeService.findEmployeesPaginated(offset, pageSize );
        return new APIResponse<>(employeeList.getSize(), employeeList);
    }
}
