package com.example.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.Equipment;
import com.example.example.repository.EquipmentRepository;

@Service
public class EquipmentService {
	
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	public List<Equipment> getAllEquipments(){
		return equipmentRepository.findAll();
	}
	
	public List<Equipment> getEquipmentsByLocation(Long locationId){
		return equipmentRepository.findByLocationId(locationId);
	}
	
	public void save(Equipment equipment) {
		equipmentRepository.save(equipment);
	}
	
	public void delete(Long id) {
		equipmentRepository.deleteById(id);
	}

}
