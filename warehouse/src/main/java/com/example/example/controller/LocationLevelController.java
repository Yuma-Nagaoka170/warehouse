package com.example.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.example.entity.LocationLevel;
import com.example.example.service.LocationLevelService;

@Controller
@RequestMapping("/location-levels")
public class LocationLevelController {
	
	@Autowired
	private LocationLevelService service;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("levels", service.getAll());
		model.addAttribute("levelForm", new LocationLevel());
		return "location-level/list";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute LocationLevel level) {
		service.addLevel(level);
		return "redirect:/location-levels";
	}

}
