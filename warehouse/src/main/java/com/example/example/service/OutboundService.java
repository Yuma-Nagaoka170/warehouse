package com.example.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.Outbound;
import com.example.example.repository.OutboundRepository;

@Service
public class OutboundService {

    @Autowired
    private OutboundRepository outboundRepository;

    public List<Outbound> getAllOutbounds() {
        return outboundRepository.findAll();
    }

    public Outbound createOutbound(Outbound outbound) {
        return outboundRepository.save(outbound);
    }

    public void deleteOutbound(Long id) {
        outboundRepository.deleteById(id);
    }
}

