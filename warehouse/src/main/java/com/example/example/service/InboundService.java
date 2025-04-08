package com.example.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.Inbound;
import com.example.example.repository.InboundRepository;

@Service
public class InboundService {

    @Autowired
    private InboundRepository inboundRepository;

    public List<Inbound> getAllInbounds() {
        return inboundRepository.findAll();
    }

    public Inbound createInbound(Inbound inbound) {
        return inboundRepository.save(inbound);
    }

    public void deleteInbound(Long id) {
        inboundRepository.deleteById(id);
    }
}
