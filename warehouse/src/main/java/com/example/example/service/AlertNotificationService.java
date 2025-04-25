package com.example.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.AlertNotification;
import com.example.example.entity.Equipment;
import com.example.example.repository.AlertNotificationRepository;

@Service
public class AlertNotificationService {

    @Autowired
    private AlertNotificationRepository repository;

    public void createAlert(String message, Equipment equipment) {
        AlertNotification alert = new AlertNotification();
        alert.setMessage(message);
        alert.setEquipment(equipment);
        alert.setCreatedAt(LocalDateTime.now());
        alert.setRead(false);
        repository.save(alert);
    }

    public List<AlertNotification> getUnreadAlerts() {
        return repository.findByReadFalseOrderByCreatedAtDesc();
    }

    public void markAsRead(Long id) {
        repository.findById(id).ifPresent(alert -> {
            alert.setRead(true);
            repository.save(alert);
        });
    }
}
