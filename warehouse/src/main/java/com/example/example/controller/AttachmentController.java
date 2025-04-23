package com.example.example.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.example.example.entity.Attachment;
import com.example.example.entity.Equipment;
import com.example.example.service.AttachmentService;
import com.example.example.service.EquipmentService;



@Controller
@RequestMapping("/attachments")
public class AttachmentController {

    @Autowired
    private AttachmentService service;

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("equipmentId") Long equipmentId) throws IOException {
        Equipment equipment = equipmentService.getById(equipmentId);
        service.save(file, equipment);
        return "redirect:/equipments/" + equipmentId;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        Attachment attachment = service.getFile(id);

        if (attachment == null || attachment.getData() == null || attachment.getFileName() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ファイルが存在しません");
        }

        String fileType = Optional.ofNullable(attachment.getFileType())
                                  .orElse("application/octet-stream");
		return null;

        
    }


}