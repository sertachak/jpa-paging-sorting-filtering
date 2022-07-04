package com.sha.jpapagingsortingfiltering.service;

import com.sha.jpapagingsortingfiltering.model.Employee;
import com.sha.jpapagingsortingfiltering.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<Employee> findEmployeesWithSorting(String field){
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Page<Employee> findEmployeesPaginated(Integer offset, Integer pageSize){
        return employeeRepository.findAll(PageRequest.of(offset, pageSize));
    }

}
