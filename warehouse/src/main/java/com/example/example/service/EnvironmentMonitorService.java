package com.example.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.EnvironmentMonitor;
import com.example.example.entity.Location;
import com.example.example.repository.EnvironmentMonitorRepository;

@Service
public class EnvironmentMonitorService {
	
	@Autowired
	private EnvironmentMonitorRepository repository;
	
	public void record(Double temperature, Double humidity, Location location) {
		EnvironmentMonitor monitor = new EnvironmentMonitor();
		monitor.setTemperature(temperature);
		monitor.setHumidity(humidity);
		monitor.setRecordedAt(LocalDateTime.now());
		monitor.setLocation(location);
		repository.save(monitor);
	}
	
	public List<EnvironmentMonitor> getLatestRecordsByLocation(Long locationId){
		return repository.findByLocationIdOrderByRecordedAtDesc(locationId);
	}
	
	public List<EnvironmentMonitor> getAll(){
		return repository.findAll();
	}

	public void record(Double temperature, Double humidity, Optional<Location> location) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
