package com.example.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findByLocationId(Long locationId);
}
