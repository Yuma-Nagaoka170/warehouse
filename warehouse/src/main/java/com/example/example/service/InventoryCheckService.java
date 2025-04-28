package com.example.example.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.InventoryCheck;
import com.example.example.entity.Product;
import com.example.example.repository.InventoryCheckRepository;

@Service
public class InventoryCheckService {

    @Autowired
    private InventoryCheckRepository repository;

    public void createInventoryCheck(Product product, int theoreticalStock, int actualStock) {
        InventoryCheck check = new InventoryCheck();
        check.setProduct(product);
        check.setTheoreticalStock(theoreticalStock);
        check.setActualStock(actualStock);
        check.setDiscrepancy(actualStock - theoreticalStock);
        check.setCheckedAt(LocalDateTime.now());
        repository.save(check);
    }

	public List<InventoryCheck> getAllInventoryChecks() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
