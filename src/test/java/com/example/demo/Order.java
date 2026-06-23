package com.example.demo;

import java.math.BigDecimal;

public class Order {
    private Long id;
    private String name;
    private BigDecimal amount;

    // constructor
    public Order(Long id, String name, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    // getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

