package com.example.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.Inspection;
import com.example.example.repository.InspectionRepository;

@Service
public class InspectionService {
	
	@Autowired
	private InspectionRepository inspectionRepository;

	public List<Inspection> getAllInspections(){
		return inspectionRepository.findAll();
	}
	
	public void saveInspection(Inspection inspection) {
		inspectionRepository.save(inspection);
	}
	
	public List<Inspection> getInspectionByEquipmentId(Long equipmentId){
		return inspectionRepository.findByEquipmentId(equipmentId);
	}

}
