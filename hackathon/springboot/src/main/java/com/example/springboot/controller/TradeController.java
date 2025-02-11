package com.example.springboot.controller;

import com.example.springboot.model.Trade;
import com.example.springboot.model.UserLeaderboard;
import com.example.springboot.repo.TradeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/trades")
public class TradeController {

    private final TradeRepository tradeRepository;

    public TradeController(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @PostMapping
    public Trade createTrade(@RequestBody Trade trade) {
        return tradeRepository.save(trade);
    }

    @GetMapping("/leaderboard")
    public List<UserLeaderboard> getLeaderboard() {
        return tradeRepository.findLeaderboard();
    }
}

