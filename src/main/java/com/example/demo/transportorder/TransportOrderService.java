package com.example.demo.transportorder;

import com.example.demo.customer.Customer;
import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import com.example.demo.transportcompany.TransportCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportOrderService {
    @Autowired
    private  TransportOrderRepository transportOrderRepository;

    @Autowired
    public TransportOrderService(TransportOrderRepository transportOrderRepository) {
        this.transportOrderRepository = transportOrderRepository;
    }

    public List<TransportOrder> getTransportOrder(){
        return transportOrderRepository.findAll(); // fetch from database
    }
    public TransportOrder getOrderById(Integer orderId) {
        TransportOrder transportOrder = transportOrderRepository.findAll().stream().filter(t -> orderId.equals(t.getId()))
                .findFirst()
                .orElse(null);
        return transportOrder;
    }

    public TransportOrder registerNewOrder(TransportOrder order) {
        return transportOrderRepository.save(order);
    }

    public TransportOrder updateTransportOrder(TransportOrder transportOrder){
        return  transportOrderRepository.save(transportOrder);
    }

    public void deleteOrderById(Integer orderId) {
        transportOrderRepository.deleteById(orderId);
    }

}
