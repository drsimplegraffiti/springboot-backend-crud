package com.abcode.springbootbackend.repository;

import com.abcode.springbootbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// we don't need to use @Repository annotation because we are extending JpaRepository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.firstName = ?1 OR e.lastName = ?1")
    List<Employee> findEmployeeByName(String firstName, String lastName);

}

