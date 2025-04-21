package com.example.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.LogHistory;
import com.example.example.repository.LogHistoryRepository;

@Service
public class LogHistoryService {

    @Autowired
    private LogHistoryRepository logHistoryRepository;

    public void log(String action, String username, String description) {
        LogHistory log = new LogHistory();
        log.setAction(action);
        log.setUsername(username);
        log.setTimestamp(LocalDateTime.now());
        log.setDescription(description);
        logHistoryRepository.save(log);
    }

    public List<LogHistory> getAllLogs() {
        return logHistoryRepository.findAllByOrderByTimestampDesc();
    }
}

