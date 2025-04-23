package com.example.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.example.service.ErrorNotificationService;

@Controller
@RequestMapping("/errors")
public class ErrorNotificationController {

    @Autowired
    private ErrorNotificationService service;

    @GetMapping
    public String listErrors(Model model) {
        model.addAttribute("errors", service.getAllErrors());
        return "error/list";
    }
}

