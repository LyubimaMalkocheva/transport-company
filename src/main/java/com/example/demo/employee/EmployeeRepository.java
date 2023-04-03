package com.example.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // this interface is responsible for data access

    //select * from employee where name = ?
    @Query("SELECT s FROM Employee s WHERE s.EGN = ?1")
    Optional<Employee> findEmployeeByEGN(String EGN);

    List<Employee> findByNameContaining(String name);
}
