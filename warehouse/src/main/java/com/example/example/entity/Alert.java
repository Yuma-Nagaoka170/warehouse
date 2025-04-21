package com.example.example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private String type; // 例: "STOCK_LOW", "INSPECTION_OVERDUE"

    private LocalDateTime createdAt;

    private boolean resolved = false;

	public void setMessage(String message2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setType(String type2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setCreatedAt(LocalDateTime now) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setResolved(boolean b) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

    // コンストラクタ・ゲッター・セッター省略
}

