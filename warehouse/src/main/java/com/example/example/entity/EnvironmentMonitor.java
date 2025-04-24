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
public class EnvironmentMonitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	
	private Double temperature;
	
	private Double humidity;
	
	@Getter
	@Setter
	private LocalDateTime recordedAt;
	
	@ManyToOne
	private Location location;

	public void setTemperature(Double temperature2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setHumidity(Double humidity2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	public void setRecordedAt(LocalDateTime now) {
		// TODO 自動生成されたメソッド・スタブ
	this.recordedAt = now;	
	}

	public void setLocation(Location location2) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	

}
