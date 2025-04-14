package com.example.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.example.dto.InventoryUpdateMessage;

@Service
public class InventoryService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // 在庫更新ロジックの例（数量更新など）
    public void updateStock(Long productId, int newQuantity) {
        // DBの在庫更新処理（省略）

        // WebSocketで通知を送信
        InventoryUpdateMessage message = new InventoryUpdateMessage(productId, newQuantity);
        messagingTemplate.convertAndSend("/topic/inventory", message);
    }
}

