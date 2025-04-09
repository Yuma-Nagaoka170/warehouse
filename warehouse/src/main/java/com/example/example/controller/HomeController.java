package com.example.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "index";  // index.html を表示（resources/templates/index.html）
    }
    
    @GetMapping("/product")
    public String product() {
    	return "product";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
