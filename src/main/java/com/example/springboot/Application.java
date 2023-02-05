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
			Optional<Department> perhapsMarketing = departmentRepository.findById("d001");
			perhapsMarketing.ifPresentOrElse(
					department -> System.out.println(department.toString()),
					() -> System.out.println("Failed"));

			for (Department dept : departmentRepository.findAll()) {
				System.out.println(dept.toString());
			}
		};
	}

}
