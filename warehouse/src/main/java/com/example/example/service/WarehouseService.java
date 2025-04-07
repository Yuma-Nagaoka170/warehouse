package com.example.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.Warehouse;
import com.example.example.repository.WarehouseRepository;

@Service
public class WarehouseService {
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	public List<Warehouse> getAllWarehouses(){
		return warehouseRepository.findAll();
	}
	
	public Warehouse createWarehouse(Warehouse warehouse) {
		return warehouseRepository.save(warehouse);
	}
	
	public Warehouse getWarehouseById(Long id) {
		return warehouseRepository.findById(id).orElse(null);
	}

}
