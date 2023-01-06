package com.abcode.springbootbackend.service;

import com.abcode.springbootbackend.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployeeById(Employee employee, Long id);

    void deleteEmployeeById(Long id);

    List<Employee> getByEmployeeName(String firstName, String lastName);

}
