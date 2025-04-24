package com.example.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.example.entity.Product;
import com.example.example.service.InventoryAuditService;
import com.example.example.service.ProductService;

@Controller
@RequestMapping("/audits")
public class InventoryAuditController {
	
	@Autowired
	private InventoryAuditService auditService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("audits",auditService.getAll());
		return "audit/list";
	}
	
	@GetMapping("/new")
	public String form(Model model) {
		model.addAttribute("products",productService.getAll());
		return "audit/form";
	}
	
	@PostMapping
	public String submit(@RequestParam Long productId,
			@RequestParam Integer actualQuantity,
			@RequestParam String auditor) {
		Product product = productService.getProductById(productId);
		auditService.aduit(product, actualQuantity, auditor);
		return "redirect:/audits";
	}

}
