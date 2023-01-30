package com.example.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FancyController {
    @GetMapping("/fancyHello")
    public String fancyHello() {
        return "fancyHello.html";
    }
}
