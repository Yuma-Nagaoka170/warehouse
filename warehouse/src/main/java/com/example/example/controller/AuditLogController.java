package com.example.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.example.service.AuditLogService;

@Controller
@RequestMapping("/logs")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    @GetMapping
    public String listLogs(Model model) {
        model.addAttribute("logs", auditLogService.getAllLogs());
        return "log/list";
    }
}

