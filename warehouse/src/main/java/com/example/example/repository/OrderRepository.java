package com.example.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
