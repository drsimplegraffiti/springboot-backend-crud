package com.abcode.springbootbackend.controller;

import com.abcode.springbootbackend.model.Employee;
import com.abcode.springbootbackend.repository.EmployeeRepository;
import com.abcode.springbootbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    // dependency injection using constructor based dependency injection
    private EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService employeeService,
                              EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }


    // create a new employee
    @PostMapping("/create")
    public ResponseEntity<Employee> saveEmployee(
            @RequestBody
            Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // Read all employees from the database
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    // get single employee by id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    // update a single employee by id
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(
            @PathVariable("id") long id,
            @RequestBody Employee employee
    ){
        return new ResponseEntity<Employee>(employeeService.updateEmployeeById(employee, id), HttpStatus.OK);
    }

    // Delete a single by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long id){
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
    }
}
