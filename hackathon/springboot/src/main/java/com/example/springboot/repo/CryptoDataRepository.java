package com.example.springboot.repo;

import com.example.springboot.model.CryptoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoDataRepository extends JpaRepository<CryptoData, Long> {
    // You can define custom query methods if needed
}
