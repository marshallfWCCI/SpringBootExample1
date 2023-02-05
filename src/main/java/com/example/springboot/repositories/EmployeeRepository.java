package com.example.springboot.repositories;

import com.example.springboot.entities.Department;
import com.example.springboot.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
