package com.example.springboot.restControllers;

import com.example.springboot.entities.Department;
import com.example.springboot.repositories.DepartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DepartmentRestController {
    private final DepartmentRepository departmentRepository;

    public DepartmentRestController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping(value = "/departments")
    public Iterable<Department> departments() {
        return departmentRepository.findAll();
    }

    @GetMapping(value = "/departments/{department_id}")
    public Optional<Department> getDeptById(@PathVariable String department_id) {
        return departmentRepository.findById(department_id);
    }
}
