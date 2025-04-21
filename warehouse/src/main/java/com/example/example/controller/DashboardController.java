package com.example.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.example.entity.Inspection;
import com.example.example.service.InspectionService;

@Controller
public class DashboardController {
	
	@Autowired
	private InspectionService inspectionService;
	
	@GetMapping("/dashboard")
	public String showDashboard(Model model) {
		List<Inspection> recentInspections = inspectionService.getRecentInspections();
		model.addAttribute("recentInspections", recentInspections);
		return "dashboard/index";
	}

}
