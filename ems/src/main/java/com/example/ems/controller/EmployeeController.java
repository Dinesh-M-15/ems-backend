package com.example.ems.controller;

import com.example.ems.model.Employee;
import com.example.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

@Autowired  
private EmployeeService employeeService;  

// Get all employees  
@GetMapping  
public List<Employee> getAllEmployees() {  
    return employeeService.getAllEmployees();  
}  

// Get employee by ID  
@GetMapping("/{id}")  
public Optional<Employee> getEmployeeById(@PathVariable Long id) {  
    return employeeService.getEmployeeById(id);  
}  

// Add a new employee  
@PostMapping  
public Employee addEmployee(@RequestBody Employee employee) {  
    return employeeService.addEmployee(employee);  
}  

// Update an employee  
@PutMapping("/{id}")  
public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {  
    return employeeService.updateEmployee(id, employee);  
}  

// Delete an employee  
@DeleteMapping("/{id}")  
public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {  
    if (employeeService.getEmployeeById(id).isPresent()) {  
        employeeService.deleteEmployee(id);  
        return ResponseEntity.ok("Employee deleted successfully");  
    } else {  
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Not Found");  
        		}  
}

}


