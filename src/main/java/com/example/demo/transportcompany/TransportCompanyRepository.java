package com.example.demo.transportcompany;

import com.example.demo.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportCompanyRepository extends JpaRepository<TransportCompany, Integer> {

    List<TransportCompany> findByIncomeLessThan(Double income);
    List<TransportCompany> findByNameContaining(String name);
}
