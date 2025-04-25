package com.example.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.EquipmentStatus;
import com.example.example.repository.EquipmentStatusRepository;

@Service
public class EquipmentStatusService {
	
	@Autowired
	private EquipmentStatusRepository equipmentStatusRepository;
	
	public EquipmentStatus getLateStatus(Long equipmentId) {
		return equipmentStatusRepository.findTopByEquipmentIdOrderByStatusChangeTimeDesc(equipmentId);
		
	}
	
	public void saveStatus(EquipmentStatus equipmentStatus) {
		equipmentStatusRepository.save(equipmentStatus);
	}

	public EquipmentStatus getLatestStatus(Long equipmentId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public void setStatus(EquipmentStatus equipmentStatus) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
