package com.abcode.springbootbackend.serviceimpl;

import com.abcode.springbootbackend.exception.ResourceNotFoundException;
import com.abcode.springbootbackend.model.Employee;
import com.abcode.springbootbackend.repository.EmployeeRepository;
import com.abcode.springbootbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    // we are using constructor based dependency injection
    private EmployeeRepository employeeRepository;
    // we don't need to use @Autowired annotation because we are using constructor based dependency injection
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if(employee.isPresent()){
//            return employee.get(); // return the employee object
//        }else {
//            throw new ResourceNotFoundException("Employee", "Id", id);
//        }
        // lambda expression to replace the above code
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployeeById(Employee employee, Long id) {
        // Check if the employee exists in database using employee id
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));

        // Update the existing employee
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        // Save the existing Employee to database
        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        // check if id exists in database
        employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getByEmployeeName(String firstName, String lastName) {
        return employeeRepository.findEmployeeByName(firstName, lastName);
    }


}
