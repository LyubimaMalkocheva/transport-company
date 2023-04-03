package com.example.demo;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;
import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import com.example.demo.transportcompany.TransportCompany;
import com.example.demo.transportcompany.TransportCompanyRepository;
import com.example.demo.transportorder.TransportOrder;
import com.example.demo.transportorder.TransportOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

@SpringBootApplication
public class DemoApplication {
//	@Autowired CustomerRepository customerRepository;
//	@Autowired TransportOrderRepository transportOrderRepository;
//	@Autowired EmployeeRepository employeeRepository;
//	@Autowired TransportCompanyRepository companyRepository;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}
}
