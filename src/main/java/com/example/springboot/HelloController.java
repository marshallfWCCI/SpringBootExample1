package com.example.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

	Logger logger = LoggerFactory.getLogger(HelloController.class);


	@GetMapping("/hello")
	public String index() {
		return "<html><body>" +
				"<h1>My first table!</h1>" +
				"<table border='1px'>" +
				" <tr>" +
				"  <td>1A</td>" +
				"  <td>1B</td>" +
				"  <td>1C</td>" +
				" </tr>" +
				" <tr>" +
				"  <td>2A</td>" +
				"  <td>2B</td>" +
				"  <td>2C</td>" +
				" </tr>" +
				"</table>" +
				"</body></html>";
	}

	@PostMapping("/process_form")
	public String process_form(@RequestBody String body) {
		logger.info(body);
		return body;
	}
//	@GetMapping("/api/v1/courses/") public void getAllCourses() {}
//
//
//	@GetMapping("/api/v1/courses/{course_id}/") public void getOneCourse() {}
//	@GetMapping("/api/v1/courses/{course_id}/modules") public void getAllModulesForOneCourse() {}
//	@GetMapping("/api/v1/courses/{course_id}/modules/{module_id}") public void getOneModuleForOneCourse() {}
//	@PostMapping("/api/v1/courses/{course_id}/modules/{module_id}") public void addOneModuleForOneCourse() {}
//	@PutMapping("/api/v1/courses/{course_id}/modules/{module_id}") public void changeOneModuleForOneCourse() {}

//	@PutMapping("/api/v1/stations/{station_id}/observations/{date}")
//
//	@GetMapping("/api/v1/stations/{station_id}/observations/");
//	@GetMapping("/api/v1/regions/se/best_price");




	// BAD @PutMapping("/api/v1/change_module/{course_id}/{module_id}")
	// NOT REST (BAD) @PutMapping("/api/v1/change_module/123/456/
	// REST @PutMapping("/api/v1/courses/123/modules/456") public void changeOneModuleForOneCourse() {}

}
