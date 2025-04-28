package com.example.example.entity;

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
public class StockAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int thresholdQuantity; // 閾値（これ以下になったらアラート）

    private boolean active; // アラートが有効かどうか

    @ManyToOne
    private Product product; // どの商品に対するアラートか
}
