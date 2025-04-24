package com.example.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.InventoryAudit;

public interface InventoryAuditRepository extends JpaRepository<InventoryAudit, Long>{

}
