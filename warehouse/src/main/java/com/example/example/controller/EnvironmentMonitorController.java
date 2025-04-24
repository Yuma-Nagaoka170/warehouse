package com.example.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.example.entity.EnvironmentMonitor;
import com.example.example.entity.Location;
import com.example.example.service.EnvironmentMonitorService;
import com.example.example.service.LocationService;

@Controller
@RequestMapping("/environment")
public class EnvironmentMonitorController {
	
	@Autowired
	private EnvironmentMonitorService monitorService;
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping
	public String showAll(Model model) {
		List<EnvironmentMonitor> monitors = monitorService.getAll();
		model.addAttribute("monitors", monitors);
		return "environment/list";
	}
	
	@PostMapping("/record")
	public String recordData(@RequestParam Double temperature,
			@RequestParam Double humidity,
			@RequestParam Long locationId) {
		Optional<Location> location = locationService.getLocationById(locationId);
		monitorService.record(temperature, humidity, location);
		return "redirect:/environment";
	}
	

}
