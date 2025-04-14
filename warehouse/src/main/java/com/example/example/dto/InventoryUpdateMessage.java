package com.example.example.dto;

public class InventoryUpdateMessage {
    private Long productId;
    private int quantity;

    public InventoryUpdateMessage(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}

