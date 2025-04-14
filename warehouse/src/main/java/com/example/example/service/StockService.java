package com.example.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.example.dto.InventoryUpdateMessage;
import com.example.example.entity.Product;
import com.example.example.entity.Stock;
import com.example.example.repository.ProductRepository;
import com.example.example.repository.StockRepository;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void updateStock(Long productId, int quantityChange) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));

        Stock stock = stockRepository.findByProduct(product).orElse(null);

        if (stock == null) {
            stock = new Stock();
            stock.setProduct(product); // setPriceじゃなくてこっち
            stock.setQuantity(0);
        }

        stock.setQuantity(stock.getQuantity() + quantityChange);
        stockRepository.save(stock); // saveAllじゃない
        messagingTemplate.convertAndSend("/topic/inventory", new InventoryUpdateMessage(productId, stock.getQuantity()));
    }
    
    public List<Stock> getStocksByWarehouseId(Long warehouseId) {
        return stockRepository.findAll().stream()
            .filter(stock -> stock.getWarehouse().getId().equals(warehouseId))
            .toList(); // Java 16以上
    }
    
    public void createOrUpdateStock(Stock stock) {
        stockRepository.save(stock); // save()はcreateとupdateの両方に対応してる
    }
    
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }


}
