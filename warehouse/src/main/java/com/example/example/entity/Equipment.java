package com.example.example.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private String status;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    
    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL)
    private List<Inspection> insepections = new ArrayList<>();
    
    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL)
    private List<Inspection> inspections = new ArrayList<>();

    
    public List<Inspection> getInspections(){
    	return inspections;
    }
    
    public void setInspections(List<Inspection> inspections) {
    	this.insepections = inspections;
    }
    // Getters & Setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }
}
