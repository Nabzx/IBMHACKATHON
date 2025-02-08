package com.example.springboot.repo;

import com.example.springboot.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    // You can define custom query methods if needed
}

