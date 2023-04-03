package com.example.demo.transportcompany;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;
import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import com.example.demo.transportorder.TransportOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportCompanyService {
    @Autowired
    private TransportCompanyRepository transportCompanyRepository;

    public void addNewTransportCompany(TransportCompany transportCompany) {
        transportCompanyRepository.save(transportCompany);
    }

    public List<TransportCompany> getTransportCompanies() {
        return transportCompanyRepository.findAll();
    }

    public TransportCompany getCompanyById(Integer id){
        TransportCompany transportCompany = transportCompanyRepository.findAll().stream().filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
        return transportCompany;
    }

    public TransportCompany registerNewCompany(TransportCompany transportCompany) {
        return transportCompanyRepository.save(transportCompany);
    }
    public TransportCompany updateTransportCompany(TransportCompany transportCompany){
        return  transportCompanyRepository.save(transportCompany);
    }

    public void deleteCompanyById(Integer id){
        transportCompanyRepository.deleteById(id);
    }
}



