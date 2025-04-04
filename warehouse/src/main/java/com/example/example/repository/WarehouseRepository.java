package com.example.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}

