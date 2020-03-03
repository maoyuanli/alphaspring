package com.alphasmart.alphaspring.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class StockTweetsDataServiceTest {

    @Autowired
    StockTweetsDataService stockTweetsDataService;

    @Test
    public void tweetsList() {
        String responseBody = stockTweetsDataService.tweetsList();

        // required by frontend
        assertTrue(responseBody.contains("tweets")
                && responseBody.contains("profileImageUrlHttps")
                && responseBody.contains("profileImageUrlHttps")
                && responseBody.contains("screenName")
                && responseBody.contains("text"));
    }

}