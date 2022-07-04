package com.sha.jpapagingsortingfiltering.repository;

import com.sha.jpapagingsortingfiltering.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
