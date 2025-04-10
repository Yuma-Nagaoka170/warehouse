package com.example.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.example.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
	@Query("SELECT s FROM Shipment s WHERE s.order.product.name LIKE %:productName%")
	List<Shipment> findByOrderProductNameContaining(@Param("productName") String productName);

}
