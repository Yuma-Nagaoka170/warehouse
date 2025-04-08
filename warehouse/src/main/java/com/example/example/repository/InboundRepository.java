package com.example.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.Inbound;

public interface InboundRepository extends JpaRepository<Inbound, Long> {
}
