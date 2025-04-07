package com.example.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findByWarehouseId(Long warehouseId);
}


