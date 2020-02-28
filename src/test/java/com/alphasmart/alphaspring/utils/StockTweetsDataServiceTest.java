package com.alphasmart.alphaspring.utils;

import com.alphasmart.alphaspring.services.StockTweetsDataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StockTweetsDataServiceTest {
    private static final Logger logger = LogManager.getLogger(StockTweetsDataServiceTest.class);

    private final String expectedSearchQuery =
            "FROM:marketwatch OR FROM:wsj OR FROM:ft OR FROM:business OR FROM:theeconomist OR FROM:cnbc OR FROM:barronsonline";

    @Test
    void testTweetSearchQueryBuilder() {
        TweetSearchQuery tweetSearchQuery = new TweetSearchQuery(TickersAndSources.getSources());
        assertEquals(expectedSearchQuery,tweetSearchQuery.getQueryString());
    }

    @Test
    void tweetsList() {
        StockTweetsDataService stockTweetsDataService = new StockTweetsDataService();
        String payload = stockTweetsDataService.tweetsList();
        assert (payload.length() > 0);
    }

}