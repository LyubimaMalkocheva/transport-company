package com.example.demo.employee;

import com.example.demo.transportcompany.TransportCompany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String name;
    private String phone;
    private String EGN;
    //private Qualification qualification;
    //private Position position;
    private Double salary;

    //this will create table
    // transport_company_id   employee_id
    // 1                      2
    // 1                      3
    // 2                      2
    // 3                      1
    @ManyToMany(mappedBy = "employees")
    private Set<TransportCompany> transportCompanies;

    public Employee() {
    }

    public Employee(Integer id, String name, String phone, String EGN, Double salary) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.EGN = EGN;
        this.salary = salary;
    }

    public Employee(String name, String phone, String EGN, Double salary) {
        this.name = name;
        this.phone = phone;
        this.EGN = EGN;
        this.salary = salary;
    }

    public Employee(String name, String phone, String EGN, Double salary, Set<TransportCompany> transportCompanies) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.EGN = EGN;
        this.salary = salary;
        this.transportCompanies = transportCompanies;
    }

    public Integer getIDemployee() {
        return id;
    }

    public void setIDemployee(Integer IDemployee) {
        this.id = IDemployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEGN() {
        return EGN;
    }

    public void setEGN(String EGN) {
        this.EGN = EGN;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }






    @Override
    public String toString() {
        return "Employee{" +
                "IDemployee=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", EGN='" + EGN + '\'' +
                ", salary=" + salary +
                '}';
    }
}
