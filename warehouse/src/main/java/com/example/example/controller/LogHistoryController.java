package com.example.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.example.service.LogHistoryService;

@Controller
@RequestMapping("/logs")
public class LogHistoryController {

    @Autowired
    private LogHistoryService logHistoryService;

    @GetMapping
    public String showLogs(Model model) {
        model.addAttribute("logs", logHistoryService.getAllLogs());
        return "log/list";
    }
}

