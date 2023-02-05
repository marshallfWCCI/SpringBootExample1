package com.example.springboot.templateControllers;

import com.example.springboot.entities.Department;
import com.example.springboot.repositories.DepartmentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepartmentController {
    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/departments.html")
    public String departmentsHTML(Model model) {
        model.addAttribute("departments", departmentRepository.findAll());
        return "departments.html";
    }
}
