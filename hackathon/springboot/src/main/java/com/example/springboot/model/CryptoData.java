package com.example.springboot.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "crypto_data")
public class CryptoData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String symbol;

    @Column(precision = 19, scale = 10, nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private LocalDateTime date;


    public CryptoData() {}

    public CryptoData(String symbol, BigDecimal price) {
        this.symbol = symbol;
        this.price = price;
        this.date = LocalDateTime.now();
    }


    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
}
