package com.example.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.example.entity.Warehouse;
import com.example.example.service.WarehouseService;

@Controller
@RequestMapping("/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    public String listWarehouses(Model model) {
        model.addAttribute("warehouses", warehouseService.getAllWarehouses());
        return "warehouses/list";  // list.html
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("warehouse", new Warehouse());
        return "warehouses/create";  // create.html
    }

    @PostMapping("/create")
    public String createWarehouse(@ModelAttribute Warehouse warehouse) {
        warehouseService.createWarehouse(warehouse);
        return "redirect:/warehouses";
    }

    @GetMapping("/{id}")
    public String viewWarehouse(@PathVariable Long id, Model model) {
        Warehouse warehouse = warehouseService.getWarehouseById(id);
        model.addAttribute("warehouse", warehouse);
        return "warehouses/detail";  // detail.html
    }
}

