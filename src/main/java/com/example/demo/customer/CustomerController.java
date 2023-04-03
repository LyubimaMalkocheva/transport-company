package com.example.demo.customer;

import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeService;
import com.example.demo.transportorder.TransportOrder;
import org.hibernate.collection.internal.CustomCollectionTypeSemantics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private  CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

//    @Autowired
//    public CustomerController(CustomerService customerService){ this.customerService = customerService;}

    @GetMapping("/getAllCustomers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/findCustomerById/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
       return customerService.getCustomerById(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    //put - to change something

    @DeleteMapping("/deleteCustomerById/{id}")
    public void deleteCustomerById(@PathVariable Integer id){
        boolean exists = customerRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("customer with id " + id + " does not exists");
        }
        customerService.deleteCustomerById(id);
        System.out.println("Customer with id - " + id +" is deleted!");
    }

    @PutMapping("/update/{id}")
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customer){
        customer.setId(id);
        return customerService.updateCustomer(customer);
    }
}
