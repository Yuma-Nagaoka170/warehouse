package com.example.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.example.entity.ErrorNotification;

@Repository
public interface ErrorNotificationRepository extends JpaRepository<ErrorNotification, Long> {
}

