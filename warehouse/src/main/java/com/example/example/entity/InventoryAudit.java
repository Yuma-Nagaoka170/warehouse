package com.example.example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class InventoryAudit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	@ManyToOne
	private Product product;
	
	private Integer actualQuantity;
	
	private Integer systemQuantity;
	
	private LocalDateTime auditedAt;
	
	private String auditor;

	public void setProduct(Product product2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setActualQuantity(Integer actualQuantity2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setSystemQuantity(Object stockQuantity) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setAuditedAt(LocalDateTime now) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setAuditor(String auditor2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	

}
