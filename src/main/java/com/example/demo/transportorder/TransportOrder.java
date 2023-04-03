package com.example.demo.transportorder;

import com.example.demo.customer.Customer;
import com.example.demo.transportcompany.TransportCompany;
import jakarta.persistence.*;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "transport_order")
public class TransportOrder {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;

    //DATE
    private String departuredate;
    private String arrivaldate;

    //DESTINATION
    private String startPoint;
    private String endPoint;

    //@Transient
    //private Map<String,String> destinations;

    //PRICE
    private Double cost;
    @Transient
    private final Double priceperkm = 5.;
    @Transient
    private final Double priceperKg = 2.5;

    //WEIGHT
    private Double Km;
    private Double Kg;

    //TYPE TRANSPORT
    private String typeTransport;

    //Order
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private TransportCompany company;

//    @OneToMany(cascade = CascadeType.ALL)
//    private Set<TransportOrder> transportOrders;


    public TransportOrder() {
    }

    public TransportOrder(String departuredate, String arrivaldate, String startPoint, String endPoint, String typeTransport, Customer customer, TransportCompany company) {
        this.departuredate = departuredate;
        this.arrivaldate = arrivaldate;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.typeTransport = typeTransport;
        this.customer=customer;
        this.company = company;
       // this.cost = method for cost
    }

    public TransportOrder(String departuredate, String arrivaldate, String startPoint, String endPoint, Double cost, Double km, Double kg, String typeTransport, Customer customer, TransportCompany company) {
        this.departuredate = departuredate;
        this.arrivaldate = arrivaldate;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.cost = cost;
        Km = km;
        Kg = kg;
        this.typeTransport = typeTransport;
        this.customer = customer;
        this.company = company;
    }

    public TransportOrder(String departuredate, String arrivaldate, String startPoint, String endPoint, Double cost, Double km, Double kg, String typeTransport, TransportCompany company) {
        this.departuredate = departuredate;
        this.arrivaldate = arrivaldate;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.cost = cost;
        Km = km;
        Kg = kg;
        this.typeTransport = typeTransport;
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(String departuredate) {
        this.departuredate = departuredate;
    }

    public String getArrivaldate() {
        return arrivaldate;
    }

    public void setArrivaldate(String arrivaldate) {
        this.arrivaldate = arrivaldate;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPriceperkm() {
        return priceperkm;
    }

    public Double getPriceperKg() {
        return priceperKg;
    }

    public Double getKm() {
        return Km;
    }

    public void setKm(Double km) {
        Km = km;
    }

    public Double getKg() {
        return Kg;
    }

    public void setKg(Double kg) {
        Kg = kg;
    }

    public String getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(String typeTransport) {
        this.typeTransport = typeTransport;
    }

    @Override
    public String toString() {
        return "TransportOrder{" +
                "id=" + id +
                ", departuredate=" + departuredate +
                ", arrivaldate=" + arrivaldate +
                ", startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                ", cost=" + cost +
                ", Km=" + Km +
                ", Kg=" + Kg +
                ", typeTransport=" + typeTransport +
                '}';
    }
}
