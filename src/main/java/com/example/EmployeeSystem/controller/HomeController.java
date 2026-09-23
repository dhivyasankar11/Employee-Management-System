package com.example.EmployeeSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.EmployeeSystem.model.Employee;
import com.example.EmployeeSystem.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class HomeController {

    @Autowired
    private EmployeeRepository repo;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee emp) {
        return repo.save(emp);
    }
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        repo.deleteById(id);
        return "Deleted";}
    @PutMapping
    public Employee updateEmployee(@RequestBody Employee emp) {
        return repo.save(emp);
        }
    
}