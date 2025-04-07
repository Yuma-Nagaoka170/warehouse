package com.example.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(String status);
}

