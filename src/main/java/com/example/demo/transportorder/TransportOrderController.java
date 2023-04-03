package com.example.demo.transportorder;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;
import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeService;
import com.example.demo.transportcompany.TransportCompany;
import com.example.demo.transportcompany.TransportCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transportorder")
public class TransportOrderController {
    @Autowired
    private TransportOrderService transportOrderService;

    @Autowired
    private TransportOrderRepository transportOrderRepository;

    @GetMapping("/getTransportOrders")
    public List<TransportOrder> getTransportOrder(){
        return transportOrderService.getTransportOrder();
    }

    @GetMapping("/getTransportOrdersById/{id}")
    public TransportOrder getOrderById(@PathVariable Integer id) {
        return transportOrderService.getOrderById(id);
    }
    //post request - can be done by postman
    @PostMapping
    public TransportOrder registerNewOrder(@RequestBody TransportOrder transportOrder){
       return transportOrderService.registerNewOrder(transportOrder);    }

    @PutMapping("/update/{id}")
    public TransportOrder updateTransportOrder(@PathVariable Integer id, @RequestBody TransportOrder transportOrder){
        transportOrder.setId(id);
        return transportOrderService.updateTransportOrder(transportOrder);
    }


    @DeleteMapping("/deleteOrderById/{id}")
    public void deleteOrderById(@PathVariable Integer id){
        boolean exists = transportOrderRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Transport order with id " + id + " does not exists");
        }
        transportOrderService.deleteOrderById(id);
        System.out.println("Transport order with id - " + id +" is deleted!");
    }

}
