package com.example.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.Location;
import com.example.example.repository.LocationRepository;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public void saveLocation(Location location) {
        locationRepository.save(location);
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
  

    public void save(Location location) {
        locationRepository.save(location);
    }

    public List<Location> getTopLocations() {
        return locationRepository.findByParentIsNull();
    }

	public List<Location> getRootLocations() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public Location getLocationById(Long parentId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

    
}

