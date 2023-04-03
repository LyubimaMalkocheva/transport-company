package com.example.demo.transportcompany;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;
import com.example.demo.customer.CustomerService;
import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/transportcompany")
public class TransportCompanyController {
    @Autowired
    private TransportCompanyService transportCompanyService;

    @Autowired
    private TransportCompanyRepository transportCompanyRepository;

    @GetMapping("/getAllCompanies")
    public List<TransportCompany> getTransportCompanies(){
        return transportCompanyService.getTransportCompanies();
    }


    @GetMapping("/findCompanyById/{id}")
    public TransportCompany getCompanyById(@PathVariable Integer id) {
        return transportCompanyService.getCompanyById(id);
    }

    @PostMapping
    public TransportCompany registerNewCompany(@RequestBody TransportCompany transportCompany){
       return transportCompanyService.registerNewCompany(transportCompany);
    }

    @PutMapping("/update/{id}")
    public TransportCompany updateTransportCompany(@PathVariable Integer id, @RequestBody TransportCompany transportCompany){
        transportCompany.setId(id);
        return transportCompanyService.updateTransportCompany(transportCompany);
    }

    @DeleteMapping("/deleteCompanyById/{id}")
    public void deleteCompanyById(@PathVariable Integer id){
        boolean exists = transportCompanyRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Transport Company with id " + id + " does not exists");
        }
        transportCompanyService.deleteCompanyById(id);
        System.out.println("Transport Company with id - " + id +" is deleted!");
    }
}
