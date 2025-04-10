package com.example.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.example.entity.Shipment;
import com.example.example.repository.ShipmentRepository;

@Service
public class ShipmentService {
	
	private final ShipmentRepository shipmentRepository;
	
	public ShipmentService(ShipmentRepository shipmentRepository) {
		this.shipmentRepository = shipmentRepository;
	}
	
	public List<Shipment> getAllShipments(){
		return shipmentRepository.findAll();
	}
	
	public Optional<Shipment> getShipmentById(Long id){
		return shipmentRepository.findById(id);
	}
	
	public Shipment saveShipmennt(Shipment shipment) {
		return shipmentRepository.save(shipment);
	}
	
	public void deleteShipment(Long id) {
		shipmentRepository.deleteById(id);
	}
	
	public List<Shipment> findShipmentsByProductName(String productName) {
	    return shipmentRepository.findByOrderProductNameContaining(productName);
	}


}
