package com.example.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.EnvironmentMonitor;

public interface EnvironmentMonitorRepository extends JpaRepository<EnvironmentMonitor, Long>{
	List<EnvironmentMonitor> findByLocationIdOrderByRecordedAtDesc(Long locationId);

}
