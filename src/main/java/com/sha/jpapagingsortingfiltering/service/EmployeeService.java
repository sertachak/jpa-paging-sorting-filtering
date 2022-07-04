package com.sha.jpapagingsortingfiltering.service;

import com.sha.jpapagingsortingfiltering.model.Employee;
import com.sha.jpapagingsortingfiltering.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void initDb(){
        List<Employee> employeeList = Arrays.asList(
                new Employee("Coko", "Yasmama"),
                new Employee("Efo", "Nd"),
                new Employee("sugar", "any")
        );
        employeeRepository.saveAll(employeeList);
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
}
