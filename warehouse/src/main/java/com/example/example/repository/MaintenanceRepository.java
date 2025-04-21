package com.example.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
	List<Maintenance> findByEquipmentId(Long equipmentId);

}
