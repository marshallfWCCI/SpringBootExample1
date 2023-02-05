package com.example.springboot.repositories;

import com.example.springboot.entities.Department;
import com.example.springboot.entities.DeptManager;
import com.example.springboot.entities.DeptManagerId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeptManagerRepository extends CrudRepository<DeptManager, DeptManagerId> {
}
