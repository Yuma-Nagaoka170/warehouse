package com.example.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.EquipmentStatus;

public interface EquipmentStatusRepository extends JpaRepository<EquipmentStatus, Long>{
	EquipmentStatus findTopByEquipmentIdOrderByStatusChangeTimeDesc(Long equipmentId);

}
