package com.example.springboot.repo;

import com.example.springboot.model.Trade;
import com.example.springboot.model.UserLeaderboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {
    @Query("SELECT new com.example.springboot.model.UserLeaderboard(u.username, SUM(t.amount)) " +
            "FROM Trade t JOIN t.user u GROUP BY u.username ORDER BY SUM(t.amount) DESC")
    List<UserLeaderboard> findLeaderboard();


}

