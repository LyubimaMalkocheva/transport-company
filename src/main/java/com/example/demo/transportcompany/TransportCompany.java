package com.example.demo.transportcompany;

import com.example.demo.customer.Customer;
import com.example.demo.employee.Employee;
import com.example.demo.transportorder.TransportOrder;
import com.example.demo.vehicle.Vehicle;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class TransportCompany {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String name;
    private Double income;

    //this will create table companies_employees_table
    // transport_company_id   employee_id
    // 1                      2
    // 1                      3
    // 2                      2
    // 3                      1
    // @ManyToMany//(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ManyToMany
    @JoinTable(name = "companies_has_employees",
            joinColumns = {
            @JoinColumn(name = "company_id")
            },
            inverseJoinColumns = {
            @JoinColumn(name = "employee_id")
            }
    )
    private Set<Employee> employees;

    @ManyToMany
    private Set<Customer> customers;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<TransportOrder> transportOrders;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles;


    public TransportCompany() {
    }

    public TransportCompany(Integer id, String name, Double income) {
        this.id = id;
        this.name = name;
        this.income = income;
        this.transportOrders = new HashSet<>();
    }

//    public TransportCompany(String name) {
//        this.name = name;
//    }

    public TransportCompany(String name, Double income) {
        this.name = name;
        this.income = income;
        this.transportOrders = new HashSet<>();
    }

    public TransportCompany(Integer id, String name, Double income, Set<Customer> customers, Set<TransportOrder> transportOrders) {
        this.id = id;
        this.name = name;
        this.income = income;
        this.customers = customers;
        this.transportOrders = transportOrders;
    }

//    public TransportCompany( String name, Double income, Set<Vehicle> vehicles) {
//        this.name = name;
//        this.income = income;
//        this.vehicles = vehicles;
//    }


    public TransportCompany(String name, Double income, Set<Employee> employees, Set<TransportOrder> transportOrders, Set<Vehicle> vehicles) {
        this.name = name;
        this.income = income;
        this.employees = employees;
        this.transportOrders = transportOrders;
        this.vehicles = vehicles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "TransportCompany{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", income=" + income +
                '}';
    }
}
