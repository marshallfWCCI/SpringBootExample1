package com.example.springboot;

import java.util.Arrays;
import java.util.Optional;

import com.example.springboot.entities.Department;
import com.example.springboot.repositories.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx, DepartmentRepository departmentRepository) {
        return (args) -> {
            for (var arg : args) {
                System.out.println("Arg is " + arg);
            }
        };
    }

}
