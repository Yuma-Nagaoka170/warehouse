package com.example.example.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.example.entity.Equipment;
import com.example.example.entity.EquipmentStatus;
import com.example.example.service.EquipmentStatusService;

@Controller
@RequestMapping("/equipment-status")
public class EquipmentStatusController {
	
	@Autowired
	private EquipmentStatusService equipmentStatusService;
	
	@GetMapping("/status")
	public String getStatus(Long equipmentId, Model model) {
		EquipmentStatus status = equipmentStatusService.getLatestStatus(equipmentId);
		model.addAttribute("status", status);
		return "equipment-status/status";
		
	}
	
	@PostMapping("/change-status")
	public String changeStatus(Long equipmentId, String status) {
		EquipmentStatus equipmentStatus = new EquipmentStatus();
		equipmentStatus.setEquipment(new Equipment());
		equipmentStatus.setStatus(status);
		equipmentStatus.setStatusChangeTime(LocalDateTime.now());
		
		equipmentStatusService.setStatus(equipmentStatus);
		
		return "redirect:/equipment-status/status?equipmentId=" + equipmentId;
	}

}
