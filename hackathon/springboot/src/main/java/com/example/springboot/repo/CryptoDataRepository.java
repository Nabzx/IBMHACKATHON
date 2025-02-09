package com.example.springboot.repo;

import com.example.springboot.model.CryptoData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CryptoDataRepository extends JpaRepository<CryptoData, Long> {
    Optional<CryptoData> findTopBySymbolOrderByDateDesc(String symbol);
}
