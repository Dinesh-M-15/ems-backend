package com.example.ems.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

@Id  
@GeneratedValue(strategy = GenerationType.IDENTITY)  
private Long id;  

private String firstName;  
private String lastName;  
private String email;  

// Constructors  
public Employee() {}  

public Employee(String firstName, String lastName, String email) {  
    this.firstName = firstName;  
    this.lastName = lastName;  
    this.email = email;  
}  

// Getters and Setters  
public Long getId() {  
    return id;  
}  

public void setId(Long id) {  
    this.id = id;  
}  

public String getFirstName() {  
    return firstName;  
}  

public void setFirstName(String firstName) {  
    this.firstName = firstName;  
}  

public String getLastName() {  
    return lastName;  
}  

public void setLastName(String lastName) {  
    this.lastName = lastName;  
}  

public String getEmail() {  
    return email;  
}  

public void setEmail(String email) {  
    this.email = email;  
    }

}