package com.example.EmployeeSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.EmployeeSystem.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}