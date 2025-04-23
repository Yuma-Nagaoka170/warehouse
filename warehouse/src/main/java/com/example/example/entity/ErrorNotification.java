package com.example.example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ErrorNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private String stackTrace;

    private LocalDateTime occurredAt;

	public void setMessage(String message2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setStackTrace(String stackTraceAsString) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setOccurredAt(LocalDateTime now) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

    // --- Getter / Setter ---
}
