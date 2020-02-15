package com.alphasmart.alphaspring.components;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StockTweetsTest {

    @Test
    void tweetQueryBuilder() {
        String expectedSearchQuery =
                "FROM:marketwatch OR FROM:wsj OR FROM:ft OR FROM:business OR FROM:theeconomist OR FROM:cnbc OR FROM:barronsonline";
        assertEquals(expectedSearchQuery,StockTweets.tweetQueryBuilder());
    }

    @Test
    void tweetsList() {
        StockTweets stockTweets = new StockTweets();
        String payload = stockTweets.tweetsList();
        assert(payload.length()>0);
    }

}