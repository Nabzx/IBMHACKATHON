package com.example.springboot.service;

import com.example.springboot.dto.CryptoPriceResponse;
import com.example.springboot.model.CryptoData;
import com.example.springboot.repo.CryptoDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;



import java.math.BigDecimal;
import java.util.Optional;


@Service
public class CryptoService {

    @Value("${crypto.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;
    private final CryptoDataRepository cryptoDataRepository;

    public CryptoService(RestTemplate restTemplate, CryptoDataRepository cryptoDataRepository) {
        this.restTemplate = restTemplate;
        this.cryptoDataRepository = cryptoDataRepository;
    }


    public CryptoData fetchAndSaveCryptoPrice(String symbol) {
        String url = apiUrl + "?ids=" + symbol + "&vs_currencies=usd";
        CryptoPriceResponse response = restTemplate.getForObject(url, CryptoPriceResponse.class);

        if (response != null && response.getPrice(symbol) != null) {
            BigDecimal price = response.getPrice(symbol);
            CryptoData cryptoData = new CryptoData(symbol, price);
            return cryptoDataRepository.save(cryptoData);
        }
        return null;
    }


    public Optional<CryptoData> getLatestCryptoPrice(String symbol) {
        return cryptoDataRepository.findTopBySymbolOrderByDateDesc(symbol);
    }
}
