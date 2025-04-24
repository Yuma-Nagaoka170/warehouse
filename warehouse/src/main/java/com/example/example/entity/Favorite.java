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
public class Favorite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Equipment equipment;
	
	private LocalDateTime addedAt;

	public void setUser(User user2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setEquipment(Equipment equipment2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setAddedAt(LocalDateTime now) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
