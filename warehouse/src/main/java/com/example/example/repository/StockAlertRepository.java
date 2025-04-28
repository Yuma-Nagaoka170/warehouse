package com.example.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.StockAlert;

public interface StockAlertRepository extends JpaRepository<StockAlert, Long> {

    List<StockAlert> findByActiveTrue();
}
