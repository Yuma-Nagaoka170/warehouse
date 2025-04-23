package com.example.example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;

    private LocalDateTime uploadedAt;

    // 必要なら、他のエンティティと紐付け
    @ManyToOne
    private Equipment equipment;

	

	public Object getEquipment() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public Object getData() {
		// TODO 自動生成されたメソッド・スタブ
		return data;
	}

	public String getFileType() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public String getFileName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	
	public void setFileName(String fileName) {
	    this.fileName = fileName;
	}

	public void setFileType(String fileType) {
	    this.fileType = fileType;
	}

	public void setData(byte[] data) {
	    this.data = data;
	}

	public void setUploadedAt(LocalDateTime uploadedAt) {
	    this.uploadedAt = uploadedAt;
	}

	public void setEquipment(Equipment equipment) {
	    this.equipment = equipment;
	}


    // --- Getter / Setter ---
}

