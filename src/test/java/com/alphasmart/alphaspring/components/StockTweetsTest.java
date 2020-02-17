package com.alphasmart.alphaspring.components;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StockTweetsTest {
    private static final Logger logger = LogManager.getLogger(StockTweetsTest.class);

    private final String expectedSearchQuery =
            "FROM:marketwatch OR FROM:wsj OR FROM:ft OR FROM:business OR FROM:theeconomist OR FROM:cnbc OR FROM:barronsonline";

    @Test
    void testTweetSearchQueryBuilder() {
        TweetSearchQuery tweetSearchQuery = new TweetSearchQuery(TickersAndSources.getSources());
        assertEquals(expectedSearchQuery,tweetSearchQuery.getQueryString());
    }

    @Test
    void tweetsList() {
        StockTweets stockTweets = new StockTweets();
        String payload = stockTweets.tweetsList();
        assert (payload.length() > 0);
    }

}