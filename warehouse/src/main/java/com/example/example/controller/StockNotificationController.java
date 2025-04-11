package com.example.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.simp.SimpMessagingTemplate;

public class StockNotificationController {
	
	private final SimpMessagingTemplate messagingTemplate;
	
	public StockNotificationController(SimpMessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}
	
	public void notifyStockUpdate(Long productId, int stockQty) {
		Map<String, Object> message = new HashMap<>();
		message.put("productId", productId);
		message.put("stockQty", stockQty);
		messagingTemplate.convertAndSend("/topic/stock", message);
	}
	
	


}
