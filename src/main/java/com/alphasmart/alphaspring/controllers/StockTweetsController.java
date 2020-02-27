package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.components.StockTweets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class StockTweetsController {

    @Autowired
    StockTweets stockTweets;

    @GetMapping("api/tweet")
    public String marketTweet(){
        return stockTweets.tweetsList();
    }
}
