package com.example.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.Outbound;

public interface OutboundRepository extends JpaRepository<Outbound, Long> {
}

