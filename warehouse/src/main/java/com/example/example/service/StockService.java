package com.example.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.Stock;
import com.example.example.repository.StockRepository;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getStocksByWarehouseId(Long warehouseId) {
        return stockRepository.findByWarehouseId(warehouseId);
    }

    public Stock createOrUpdateStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}

