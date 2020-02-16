package com.alphasmart.alphaspring.components;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StockTweetsTest {

    private final String expectedSearchQuery =
            "FROM:marketwatch OR FROM:wsj OR FROM:ft OR FROM:business OR FROM:theeconomist OR FROM:cnbc OR FROM:barronsonline";

    @Test
    void tweetQueryBuilder() {
        assertEquals(expectedSearchQuery,StockTweets.tweetQueryBuilder());
    }

    @Test
    void testTweetSearchQueryBuilder(){
        TweetSearchQueryBuilder builder = new TweetSearchQueryBuilder();
        List<String> sources = TickersAndSources.getSources();
        sources.forEach(source->builder.withSource(source));
        String builtQuery = builder.build();
        assertEquals(expectedSearchQuery,builtQuery);
    }

    @Test
    void tweetsList() {
        StockTweets stockTweets = new StockTweets();
        String payload = stockTweets.tweetsList();
        assert(payload.length()>0);
    }

}