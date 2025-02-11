package com.example.springboot.controller;

import com.example.springboot.model.CryptoData;
import com.example.springboot.service.CryptoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@Controller
@RequestMapping("/crypto")
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/price/{symbol}")
    public BigDecimal getCryptoPrice(@PathVariable String symbol) {
        Optional<CryptoData> cryptoData = cryptoService.getLatestCryptoPrice(symbol.toLowerCase());
        return cryptoData.map(CryptoData::getPrice).orElse(null);
    }

    @PostMapping("/fetch/{symbol}")
    public CryptoData fetchAndSaveCryptoPrice(@PathVariable String symbol) {
        return cryptoService.fetchAndSaveCryptoPrice(symbol.toLowerCase());
    }
}
