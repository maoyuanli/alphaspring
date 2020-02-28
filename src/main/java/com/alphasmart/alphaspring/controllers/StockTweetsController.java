package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.services.StockTweetsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class StockTweetsController {

    @Autowired
    StockTweetsDataService stockTweetsDataService;

    @GetMapping("api/tweet")
    public String marketTweet(){
        return stockTweetsDataService.tweetsList();
    }
}
