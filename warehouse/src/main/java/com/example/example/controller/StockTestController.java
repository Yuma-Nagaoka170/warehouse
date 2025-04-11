package com.example.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class StockTestController {
	
	private final SimpMessagingTemplate messagingTemplate;
	
	public StockTestController(SimpMessagingTemplate messagingTemplate) {
		this.messagingTemplate = messagingTemplate;
	}
	
	@GetMapping("/stock")
	public String sendTestStockNotification(@RequestParam Long productId, @RequestParam int stockQty) {
		Map<String, Object> message = new HashMap<>();
		message.put("productId", productId);
		message.put("stockqty", stockQty);
		
		messagingTemplate.convertAndSend("/topic/stock", message);
		
		return "通知送信済み: productID=" + productId +", stockQty=" + stockQty;
	}
}
