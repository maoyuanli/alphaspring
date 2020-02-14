package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.components.StockTweets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class StockTweetsController {

    @Autowired
    StockTweets stockTweets;

    @RequestMapping(method = RequestMethod.GET, path = "api/tweet")
    public String marketTweet(){
        return stockTweets.tweetsList();
    }
}
