package com.example.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.example.entity.StockAlert;
import com.example.example.repository.StockAlertRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockAlertService {

    private final StockAlertRepository stockAlertRepository;

    public List<StockAlert> findAll() {
        return stockAlertRepository.findAll();
    }

    public StockAlert save(StockAlert stockAlert) {
        return stockAlertRepository.save(stockAlert);
    }

    public void deleteById(Long id) {
        stockAlertRepository.deleteById(id);
    }

    public List<StockAlert> findActiveAlerts() {
        return stockAlertRepository.findByActiveTrue();
    }
}
