package com.example.demo.vehicle;

import com.example.demo.transportcompany.TransportCompany;
import jakarta.persistence.*;

@Entity
@Table
public class Vehicle {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private TypeVehicle typeVehicle;
    private String brand;

    @ManyToOne
    private TransportCompany company;


    public Vehicle() {
    }

    public Vehicle(Integer id, TypeVehicle typeVehicle, String brand) {
        this.id = id;
        this.typeVehicle = typeVehicle;
        this.brand = brand;
    }

    public Vehicle(TypeVehicle typeVehicle, String brand) {
        this.typeVehicle = typeVehicle;
        this.brand = brand;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeVehicle getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(TypeVehicle typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", typeVehicle=" + typeVehicle +
                ", brand='" + brand + '\'' +
                '}';
    }
}
