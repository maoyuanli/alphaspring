package com.alphasmart.alphaspring.components;

import org.junit.jupiter.api.Test;

class StockTweetsTest {

    @Test
    void tweetQueryBuilder() {
        String query = StockTweets.tweetQueryBuilder();
        System.out.println(query);
        assert query.length()>0;
    }

    @Test
    void tweetsList() {
        StockTweets stockTweets = new StockTweets();
        String payload = stockTweets.tweetsList();
        System.out.println(payload);
        assert payload.length() > 0;
    }

    @Test
    void twitterInstance() {
    }
}