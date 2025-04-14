package com.example.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.Product;
import com.example.example.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

	Optional<Stock> findByProduct(Product product);

}


