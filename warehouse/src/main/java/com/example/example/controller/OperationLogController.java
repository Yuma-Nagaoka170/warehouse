package com.example.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.example.service.OperationLogService;

@Controller
@RequestMapping("/operation-logs")
public class OperationLogController {
	
	@Autowired
	private OperationLogService service;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("logs", service.findAll());
		return "operationlog/list";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam String operation, @RequestParam String operator) {
		service.save(operation,  operator);
		return "redirect:/operation-logs";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/operation-logs";
	}

}
