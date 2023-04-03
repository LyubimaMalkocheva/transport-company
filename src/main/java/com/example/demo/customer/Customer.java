package com.example.demo.customer;

import com.example.demo.transportcompany.TransportCompany;
import com.example.demo.transportorder.TransportOrder;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<TransportOrder> transportOrders;

    @ManyToMany(mappedBy = "customers")
    private Set<TransportCompany> transportCompanies;

    public Customer() {
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.transportOrders = new HashSet<>();
    }

    public Customer(Integer id, String name, String email, Set<TransportOrder> transportOrders, Set<TransportCompany> transportCompanies) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.transportOrders = transportOrders;
        this.transportCompanies = transportCompanies;
    }

    public Customer(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Customer(Integer id, String name, String email, Set<TransportCompany> transportCompanies) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.transportCompanies = transportCompanies;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<TransportOrder> getTransportOrders() {
        return transportOrders;
    }

    public void setTransportOrders(Set<TransportOrder> transportOrders) {
        this.transportOrders = transportOrders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", transportOrders=" + transportOrders +
                '}';
    }
}

