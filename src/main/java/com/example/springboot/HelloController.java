package com.example.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

	Logger logger = LoggerFactory.getLogger(HelloController.class);


	@GetMapping("/hello")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@PostMapping("/process_form")
	public String process_form(@RequestBody String body) {
		logger.info(body);
		return body;
	}
}
