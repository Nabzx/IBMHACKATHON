package com.example.springboot.model;

import java.math.BigDecimal;

public class UserLeaderboard {
    private String username;
    private BigDecimal totalAmount; // Use BigDecimal for financial calculations

    public UserLeaderboard(String username, BigDecimal totalAmount) {
        this.username = username;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
}
