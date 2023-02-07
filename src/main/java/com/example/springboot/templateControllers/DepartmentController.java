package com.example.springboot.templateControllers;

import com.example.springboot.entities.Department;
import com.example.springboot.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Thymeleaf controller methods do two things:
// 1. Populate the org.springframework.ui.Model (which is the paramter to the method) with some data.
// 2. Give the name of the template that expects that data.
@Controller
public class DepartmentController {
    private final DepartmentRepository departmentRepository;

    public DepartmentController(@Autowired DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/departments.html")
    public String departmentsHTML(Model model) {
        model.addAttribute("departments", departmentRepository.findAll());
        return "departments.html";
    }
}
