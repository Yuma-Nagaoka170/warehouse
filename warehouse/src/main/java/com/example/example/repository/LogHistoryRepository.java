package com.example.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.example.entity.LogHistory;

@Repository
public interface LogHistoryRepository extends JpaRepository<LogHistory, Long> {
    List<LogHistory> findAllByOrderByTimestampDesc();
}

