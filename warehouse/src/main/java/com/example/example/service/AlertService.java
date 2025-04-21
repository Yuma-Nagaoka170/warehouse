package com.example.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.Alert;
import com.example.example.repository.AlertRepository;

@Service
public class AlertService {
    @Autowired
    private AlertRepository alertRepository;

    public List<Alert> getActiveAlerts() {
        return alertRepository.findByResolvedFalse();
    }

    public void createAlert(String message, String type) {
        Alert alert = new Alert();
        alert.setMessage(message);
        alert.setType(type);
        alert.setCreatedAt(LocalDateTime.now());
        alertRepository.save(alert);
    }

    public void resolveAlert(Long alertId) {
        Optional<Alert> alertOpt = alertRepository.findById(alertId);
        alertOpt.ifPresent(alert -> {
            alert.setResolved(true);
            alertRepository.save(alert);
        });
    }
}
