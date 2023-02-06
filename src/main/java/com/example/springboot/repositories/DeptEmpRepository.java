package com.example.springboot.repositories;

import com.example.springboot.entities.Department;
import com.example.springboot.entities.DeptEmp;
import com.example.springboot.entities.DeptEmpId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeptEmpRepository extends CrudRepository<DeptEmp, DeptEmpId> {
}
