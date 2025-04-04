package com.example.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
