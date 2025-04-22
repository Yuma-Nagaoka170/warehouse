package com.example.example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String action;
    private String entity;
    private String entityId;

    private LocalDateTime timestamp;

	public void setUsername(String username2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setAction(String action2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setEntity(String entity2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setEntityId(String entityId2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setTimestamp(LocalDateTime now) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

    // getter/setter省略
}

