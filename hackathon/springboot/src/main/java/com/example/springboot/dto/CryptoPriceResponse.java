package com.example.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Map;

public class CryptoPriceResponse {

    @JsonProperty
    private Map<String, Map<String, BigDecimal>> prices;

    public Map<String, Map<String, BigDecimal>> getPrices() {
        return prices;
    }

    public void setPrices(Map<String, Map<String, BigDecimal>> prices) {
        this.prices = prices;
    }


    public BigDecimal getPrice(String symbol) {
        if (prices != null && prices.containsKey(symbol) && prices.get(symbol).containsKey("usd")) {
            return prices.get(symbol).get("usd");  // Extracts USD price
        }
        return null;
    }
}
