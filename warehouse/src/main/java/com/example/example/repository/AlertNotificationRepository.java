package com.example.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.AlertNotification;

public interface AlertNotificationRepository extends JpaRepository<AlertNotification, Long> {
    List<AlertNotification> findByReadFalseOrderByCreatedAtDesc();
}
