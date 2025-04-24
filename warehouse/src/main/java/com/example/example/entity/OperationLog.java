package com.example.example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class OperationLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	private String username;
	
	private String action;
	
	private String target;
	
	private LocalDateTime timestamp;

	public void setOperation(String operation) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setOperator(String operator) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setTimestamp(LocalDateTime now) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
