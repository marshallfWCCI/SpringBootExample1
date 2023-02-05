package com.example.springboot.repositories;

import com.example.springboot.entities.Department;
import com.example.springboot.entities.Salary;
import com.example.springboot.entities.SalaryId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SalaryRepository extends CrudRepository<Salary, SalaryId> {
}
