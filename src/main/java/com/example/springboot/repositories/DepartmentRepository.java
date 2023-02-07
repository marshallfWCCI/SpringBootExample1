package com.example.springboot.repositories;

import com.example.springboot.entities.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// Hey, it's clear what I want -- something that knows how to be a DepartmentRepository,
// so just do all of the boring work for me.  All I need to tell you is that the repository
// is for objects of class Department and they're indexed by Strings.
// Create
// Read
// Update
// Delete
public interface DepartmentRepository extends CrudRepository<Department, String> {
}
