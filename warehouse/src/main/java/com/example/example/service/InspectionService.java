package com.example.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.Inspection;
import com.example.example.repository.InspectionRepository;

@Service
public class InspectionService {

    @Autowired
    private InspectionRepository inspectionRepository;

    public List<Inspection> getAllInspections() {
        return inspectionRepository.findAll();
    }

    public List<Inspection> getInspectionsByEquipmentId(Long equipmentId) {
        return inspectionRepository.findByEquipmentId(equipmentId);
    }

    public void saveInspection(Inspection inspection) {
        inspectionRepository.save(inspection);
    }

    public Inspection getInspectionById(Long id) {
        return inspectionRepository.findById(id).orElse(null);
    }

    public void deleteInspection(Long id) {
        inspectionRepository.deleteById(id);
    }
	
    public List<Inspection> getRecentInspections() {
        return inspectionRepository.findTop5ByOrderByInspectionDateDesc();
    }


}
