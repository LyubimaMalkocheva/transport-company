package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer) {
       return customerRepository.save(customer);
    }

    public void deleteCustomerById(Integer customerId){
        customerRepository.deleteById(customerId);
    }

    public Customer getCustomerById(Integer id){
        Customer customer = customerRepository.findAll().stream().filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
        return customer;
    }

    public Customer updateCustomer(Customer customer){
        return  customerRepository.save(customer);
    }
}
