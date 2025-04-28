package com.example.example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class InventoryCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product; // 対象の商品

    private int theoreticalStock; // 理論在庫

    private int actualStock; // 実在庫（棚卸しでカウント）

    private int discrepancy; // 差異

    private LocalDateTime checkedAt;
}
