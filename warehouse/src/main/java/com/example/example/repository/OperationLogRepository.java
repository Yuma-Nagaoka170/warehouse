package com.example.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.OperationLog;

public interface OperationLogRepository extends JpaRepository<OperationLog, Long>{

}
