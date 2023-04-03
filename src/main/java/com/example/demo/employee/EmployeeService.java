package com.example.demo.employee;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id){
        Employee employee = employeeRepository.findAll().stream().filter(t -> id.equals(t.getIDemployee()))
                .findFirst()
                .orElse(null);
        return employee;
    }

    public Employee registerNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEGN(employee.getEGN());
        if(employeeOptional.isPresent()){
            throw new IllegalStateException("EGN taken");
        }
        //if this egn does not exist I will save the employee in the table
       return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        return  employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Integer id){
            employeeRepository.deleteById(id);
    }


}


