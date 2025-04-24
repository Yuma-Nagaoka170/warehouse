package com.example.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.LocationLevel;
import com.example.example.repository.LocationLevelRepository;

@Service
public class LocationLevelService {
	
	@Autowired
	private LocationLevelRepository repository;
	
	public List<LocationLevel> getAll(){
		return repository.findAllByOrderByOrderNumberAsc();
		
	}
	
	public void addLevel(LocationLevel level) {
		repository.save(level);
	}

}
