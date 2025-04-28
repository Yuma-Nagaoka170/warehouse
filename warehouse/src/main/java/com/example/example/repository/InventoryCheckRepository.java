package com.example.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.InventoryCheck;

public interface InventoryCheckRepository extends JpaRepository<InventoryCheck, Long> {
}
