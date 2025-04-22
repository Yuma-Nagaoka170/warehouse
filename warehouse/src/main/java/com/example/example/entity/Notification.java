package com.example.example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String message;

    private LocalDateTime createdAt;

    private boolean read;  // 既読/未読フラグ

	public void setTitle(String title2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setMessage(String message2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setCreatedAt(LocalDateTime now) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setRead(boolean b) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

    // Getter/Setter
}

