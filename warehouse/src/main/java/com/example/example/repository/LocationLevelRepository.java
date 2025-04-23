package com.example.example.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.LocationLevel;

public interface LocationLevelRepository extends JpaRepository<LocationLevel, Long> {
    List<LocationLevel> findAllByOrderByOrderNumberAsc();
}

