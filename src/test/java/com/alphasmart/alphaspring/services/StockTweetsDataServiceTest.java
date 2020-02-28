package com.alphasmart.alphaspring.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StockTweetsDataServiceTest {

    @Test
    void tweetsList() {
        StockTweetsDataService stockTweetsDataService = new StockTweetsDataService();
        String responseBody = stockTweetsDataService.tweetsList();

        // required by frontend
        assertTrue(responseBody.contains("tweets")
                && responseBody.contains("profileImageUrlHttps")
                && responseBody.contains("profileImageUrlHttps")
                && responseBody.contains("screenName")
                && responseBody.contains("text") );
    }

}