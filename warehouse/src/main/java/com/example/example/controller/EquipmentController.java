package com.example.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.example.entity.Equipment;
import com.example.example.service.EquipmentService;
import com.example.example.service.LocationService;

@Controller
@RequestMapping
public class EquipmentController {
	
	@Autowired
	private EquipmentService equipmentService;
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("equipments",equipmentService.getAllEquipments());
		return "equipments/list";
	}
	
	@GetMapping("/create")
	public String showCreateForm(Model model) {
		model.addAttribute("equipment", new Equipment());
		model.addAttribute("locations", locationService.getAllLocations());
		return "equipments/create";

	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute Equipment equipment) {
		equipmentService.save(equipment);
		return "redirect:/equipments";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		equipmentService.delete(id);
		return "redirect:/equipments";
	}

}
