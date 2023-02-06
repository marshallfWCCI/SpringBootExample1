package com.example.springboot.repositories;

import com.example.springboot.entities.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartmentRepository extends CrudRepository<Department, String> {
}
