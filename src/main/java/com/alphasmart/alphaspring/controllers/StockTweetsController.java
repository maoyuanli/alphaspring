package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.services.StockTweetsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class StockTweetsController {

    private StockTweetsDataService stockTweetsDataService;

    @Autowired
    public StockTweetsController(StockTweetsDataService stockTweetsDataService) {
        this.stockTweetsDataService = stockTweetsDataService;
    }

    @GetMapping("api/tweet")
    public String marketTweet() {
        return stockTweetsDataService.tweetsList();
    }
}
