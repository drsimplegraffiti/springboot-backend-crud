package com.abcode.springbootbackend.repository;

import com.abcode.springbootbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// we don't need to use @Repository annotation because we are extending JpaRepository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

