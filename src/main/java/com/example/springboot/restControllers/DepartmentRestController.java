package com.example.springboot.restControllers;

import com.example.springboot.entities.Department;
import com.example.springboot.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DepartmentRestController {
    private final DepartmentRepository departmentRepository;

    public DepartmentRestController(@Autowired DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // curl -v http://localhost:8080/departments
    @GetMapping(value = "/departments")
    public Iterable<Department> departments() {
        return departmentRepository.findAll();
    }

    // curl -v http://localhost:8080/departments/d008
    @GetMapping(value = "/departments/{department_id}")
    public Optional<Department> getDeptById(@PathVariable String department_id) {
        return departmentRepository.findById(department_id);
    }

    // curl -v http://localhost:8080/departments/d008 -H 'Content-Type: application/json' -d '{"id":"d008","deptName":"Research and Development"}'
    @PostMapping(value = "/departments/{department_id}")
    public Department getDeptById(@RequestBody Department newDepartmentEntity,
                                  @PathVariable String department_id) {
        final Optional<Department> fromDatabase = departmentRepository.findById(department_id);

        return fromDatabase
                // What do to if the Optional contains an entity
                .map((entity) -> {
                    entity.setDeptName(newDepartmentEntity.getDeptName());
                    return departmentRepository.save(entity);
                })
                // What to do if the Optional doesn't contain an entity.
                .orElseGet(() -> {
                    newDepartmentEntity.setId(department_id);
                    return departmentRepository.save(newDepartmentEntity);
                });
    }
}
