package com.example.demo.employee;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;
import com.example.demo.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/getAllEmployees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/findEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee registerNewEmployee(@RequestBody Employee employee){
         return employeeService.registerNewEmployee(employee);
    }

    /*//delete employee
    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Integer employeeId){
        employeeService.deleteEmployee(employeeId);
    }*/
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){
        employee.setIDemployee(id);
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public void deleteEmployeeById(@PathVariable Integer id){
        boolean exists = employeeRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Employee with id " + id + " does not exists");
        }
        employeeService.deleteEmployeeById(id);
        System.out.println("Employee with id - " + id +" is deleted!");
    }

}