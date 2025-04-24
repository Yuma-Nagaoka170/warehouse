package com.example.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.example.entity.OperationLog;
import com.example.example.repository.OperationLogRepository;

@Service
public class OperationLogService {
	
	
	@Autowired
	private OperationLogRepository repository;
	
	public List<OperationLog> findAll(){
		return repository.findAll();
		
	}
	
	public void save(String operation, String operator) {
		OperationLog log = new OperationLog();
		log.setOperation(operation);
		log.setOperator(operator);
		log.setTimestamp(LocalDateTime.now());
		repository.save(log);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
