package com.example.springboot.restControllers;

import com.example.springboot.entities.DeptManager;
import com.example.springboot.repositories.DeptManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptManagerRestController {
    private final DeptManagerRepository repository;

    public DeptManagerRestController(@Autowired DeptManagerRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/deptManagers")
    public Iterable<DeptManager> departments() {
        return repository.findAll();
    }
}
