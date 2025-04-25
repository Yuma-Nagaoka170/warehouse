package com.example.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.example.entity.AlertNotification;
import com.example.example.service.AlertNotificationService;

@Controller
@RequestMapping("/alerts")
public class AlertNotificationController {

    @Autowired
    private AlertNotificationService service;

    @GetMapping
    public String listAlerts(Model model) {
        List<AlertNotification> alerts = service.getUnreadAlerts();
        model.addAttribute("alerts", alerts);
        return "alert/list";
    }

    @PostMapping("/read/{id}")
    public String markAsRead(@PathVariable Long id) {
        service.markAsRead(id);
        return "redirect:/alerts";
    }
}

