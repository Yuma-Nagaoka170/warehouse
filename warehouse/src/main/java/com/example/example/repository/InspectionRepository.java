package com.example.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.Inspection;

public interface InspectionRepository extends JpaRepository<Inspection, Long>{
	List<Inspection> findByEquipmentId(Long equipmentId);

	
	List<Inspection> findTop5ByOrderByInspectionDateDesc();


}
