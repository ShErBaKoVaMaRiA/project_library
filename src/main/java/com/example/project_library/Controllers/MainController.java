package com.example.project_library.Controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Controller
public class MainController {
    @GetMapping("/home")
    public String home() {
        return "main/index_home";
    }
}
