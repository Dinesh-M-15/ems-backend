package com.example.ems.service;

import com.example.ems.model.Employee;
import com.example.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

@Autowired  
private EmployeeRepository employeeRepository;  

// Get all employees  
public List<Employee> getAllEmployees() {  
    return employeeRepository.findAll();  
}  

// Get employee by ID  
public Optional<Employee> getEmployeeById(Long id) {  
    return employeeRepository.findById(id);  
}  

// Add employee  
public Employee addEmployee(Employee employee) {  
    return employeeRepository.save(employee);  
}  

// Update employee  
public Employee updateEmployee(Long id, Employee updatedEmployee) {  
    Optional<Employee> existingEmployee = employeeRepository.findById(id);  
    if (existingEmployee.isPresent()) {  
        Employee emp = existingEmployee.get();  
        emp.setFirstName(updatedEmployee.getFirstName());  
        emp.setLastName(updatedEmployee.getLastName());  
        emp.setEmail(updatedEmployee.getEmail());  
        return employeeRepository.save(emp);  
    }  
    return null; // Handle properly in the controller  
}  

// Delete employee  
public void deleteEmployee(Long id) {  
    employeeRepository.deleteById(id);  
    }

}




