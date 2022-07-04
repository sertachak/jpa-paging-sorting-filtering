package com.sha.jpapagingsortingfiltering.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Employee_Id_Generator")
    @SequenceGenerator(name = "Employee_Id_Generator",
            sequenceName = "Employee_Id_Generator")
    private Long id;
    private String fistName;
    private String lastName;

    public Employee() {
    }

    public Employee(String fistName, String lastName) {
        this.fistName = fistName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
