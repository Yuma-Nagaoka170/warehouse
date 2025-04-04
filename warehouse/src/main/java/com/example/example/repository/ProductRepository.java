package com.example.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
