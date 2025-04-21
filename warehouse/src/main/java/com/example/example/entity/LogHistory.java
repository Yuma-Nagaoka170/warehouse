package com.example.example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LogHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action; // 例: "CREATE_PRODUCT", "UPDATE_STOCK", "DELETE_LOCATION"

    private String username;

    private LocalDateTime timestamp;

    private String description;

	public void setAction(String action2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setUsername(String username2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setTimestamp(LocalDateTime now) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setDescription(String description2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

    // Getter/Setter
}

