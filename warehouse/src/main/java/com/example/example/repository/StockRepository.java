package com.example.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.example.entity.Location;
import com.example.example.entity.Product;
import com.example.example.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

	Optional<Stock> findByProduct(Product product);

	@Query("SELECT SUM(s.quantity) FROM Stock s WHERE s.location.id = :locationId")
	Integer getTotalQuantityByLocationId(@Param("locationId") Long locationId);
	
	List<Stock> findByLocation(Location location);
	
	List<Stock> findByLocationId(Long locationId);


}


