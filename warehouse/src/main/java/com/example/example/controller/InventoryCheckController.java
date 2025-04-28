package com.example.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.example.entity.Product;
import com.example.example.service.InventoryCheckService;
import com.example.example.service.ProductService;

@Controller
@RequestMapping("/inventory-check")
public class InventoryCheckController {

    @Autowired
    private InventoryCheckService inventoryCheckService;

    @Autowired
    private ProductService productService;

    @GetMapping("/form")
    public String showCheckForm(Model model) {
        model.addAttribute("products", productService.findAll());
        return "inventory-check/form";
    }

    @PostMapping("/submit")
    public String submitCheck(@RequestParam Long productId, 
                               @RequestParam int theoreticalStock,
                               @RequestParam int actualStock) {
        Product product = productService.findById(productId);
        inventoryCheckService.createInventoryCheck(product, theoreticalStock, actualStock);
        return "redirect:/inventory-check/form";
    }
}
