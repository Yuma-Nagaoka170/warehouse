package com.example.example.controller;

import java.util.List;

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
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private LocationService locationService;

    @GetMapping
    public String listEquipment(Model model) {
        List<Equipment> equipmentList = equipmentService.getAllEquipment();
        model.addAttribute("equipmentList", equipmentList);
        return "equipment/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("equipment", new Equipment());
        model.addAttribute("locations", locationService.getAllLocations());
        return "equipment/add";
    }

    @PostMapping("/add")
    public String addEquipment(@ModelAttribute Equipment equipment) {
        equipmentService.saveEquipment(equipment);
        return "redirect:/equipment";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Equipment equipment = equipmentService.getEquipmentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid equipment ID"));
        model.addAttribute("equipment", equipment);
        model.addAttribute("locations", locationService.getAllLocations());
        return "equipment/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateEquipment(@PathVariable Long id, @ModelAttribute Equipment equipment) {
        Equipment existing = equipmentService.getEquipmentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid equipment ID"));
        existing.setName(equipment.getName());
        existing.setType(equipment.getType());
        existing.setStatus(equipment.getStatus());
        existing.setLocation(equipment.getLocation());
        equipmentService.saveEquipment(existing);
        return "redirect:/equipment";
    }

    @PostMapping("/{id}/delete")
    public String deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
        return "redirect:/equipment";
    }
}
