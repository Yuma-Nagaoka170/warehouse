package com.example.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.InventoryAudit;
import com.example.example.entity.Product;
import com.example.example.repository.InventoryAuditRepository;

@Service
public class InventoryAuditService {
	
	@Autowired
	private InventoryAuditRepository repository;
	
	public void audit(Product product, Integer actualQuantity, String auditor) {
		InventoryAudit audit = new InventoryAudit();
		audit.setProduct(product);
		audit.setActualQuantity(actualQuantity);
		audit.setSystemQuantity(product.getStockQuantity());
		audit.setAuditedAt(LocalDateTime.now());
		audit.setAuditor(auditor);
		repository.save(audit);	
		}
	
	public List<InventoryAudit> getAll(){
		return repository.findAll();
	}

	public void aduit(Product product, Integer actualQuantity, String auditor) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
