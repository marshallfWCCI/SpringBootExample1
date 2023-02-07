package com.example.springboot.templateControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


// When methods are defined within a class with the @Controller annotation, Spring
// interprets it as the name of a template in src/main/resources/templates. If it can't
// find such a resource, it tries again with an .html at the end.
@Controller
public class FancyController {
    @GetMapping("/fancyHello")
    public String fancyHello() {
        return "fancyHello";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);

        // This tells Spring to look at src/main/resources/temples/greeting.html
        return "greeting";
    }
}
