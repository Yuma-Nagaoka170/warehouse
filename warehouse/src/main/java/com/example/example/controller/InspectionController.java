package com.example.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.example.entity.Inspection;
import com.example.example.service.EquipmentService;
import com.example.example.service.InspectionService;

@Controller
@RequestMapping("/inspections")
public class InspectionController {
	
	@Autowired
	private InspectionService inspectionService;
	
	@Autowired
	private EquipmentService equipmentService;
	
	@GetMapping
	public String listInspections(Model model) {
		model.addAttribute("inspections", inspectionService.getAllInspections());
		return "inspection/list";
	}
	
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("inspection", new Inspection());
		model.addAttribute("equipmentList",new Inspection());
		return "inspection/add";
	}
	
	 @PostMapping("/add")
	    public String addInspection(@ModelAttribute Inspection inspection) {
	        inspectionService.saveInspection(inspection);
	        return "redirect:/inspections";
	    }

}
