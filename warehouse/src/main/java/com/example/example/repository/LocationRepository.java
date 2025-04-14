package com.example.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
	List<Location> findByParentIsNull();
}

