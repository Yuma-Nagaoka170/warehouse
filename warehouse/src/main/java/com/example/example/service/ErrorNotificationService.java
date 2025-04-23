package com.example.example.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.example.entity.ErrorNotification;
import com.example.example.repository.ErrorNotificationRepository;

@Service
public class ErrorNotificationService {

    @Autowired
    private ErrorNotificationRepository repository;

    public void logError(Exception e) {
        ErrorNotification error = new ErrorNotification();
        error.setMessage(e.getMessage());
        error.setStackTrace(getStackTraceAsString(e));
        error.setOccurredAt(LocalDateTime.now());
        repository.save(error);
    }

    public List<ErrorNotification> getAllErrors() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "occurredAt"));
    }

    private String getStackTraceAsString(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}
