package com.example.example.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.example.entity.Attachment;
import com.example.example.entity.Equipment;
import com.example.example.repository.AttachmentRepository;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentRepository repository;

    public void save(MultipartFile file, Equipment equipment) throws IOException {
        Attachment attachment = new Attachment();
        attachment.setFileName(file.getOriginalFilename());
        attachment.setFileType(file.getContentType());
        attachment.setData(file.getBytes());
        attachment.setUploadedAt(LocalDateTime.now());
        attachment.setEquipment(equipment);
        repository.save(attachment);
    }

    public List<Attachment> getAttachmentsByEquipment(Equipment equipment) {
        return repository.findAll().stream()
                .filter(att -> equipment.equals(att.getEquipment()))
                .collect(Collectors.toList());
    }

    public Attachment getFile(Long id) {
        return repository.findById(id).orElseThrow();
    }
}

