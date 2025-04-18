package com.example.example.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Inspection {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private LocalDate inspectionDate;

	    private String inspector;

	    @Column(length = 1000)
	    private String notes;

	    @Column(length = 1000)
	    private String actionTaken;

	    @ManyToOne
	    @JoinColumn(name = "equipment_id")
	    private Equipment equipment;

	    // --- getter/setter ---
	    public Long getId() {
	        return id;
	    }

	    public LocalDate getInspectionDate() {
	        return inspectionDate;
	    }

	    public void setInspectionDate(LocalDate inspectionDate) {
	        this.inspectionDate = inspectionDate;
	    }

	    public String getInspector() {
	        return inspector;
	    }

	    public void setInspector(String inspector) {
	        this.inspector = inspector;
	    }

	    public String getNotes() {
	        return notes;
	    }

	    public void setNotes(String notes) {
	        this.notes = notes;
	    }

	    public String getActionTaken() {
	        return actionTaken;
	    }

	    public void setActionTaken(String actionTaken) {
	        this.actionTaken = actionTaken;
	    }

	    public Equipment getEquipment() {
	        return equipment;
	    }

	    public void setEquipment(Equipment equipment) {
	        this.equipment = equipment;
	    }
	}
