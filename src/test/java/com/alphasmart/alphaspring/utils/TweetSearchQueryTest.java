package com.alphasmart.alphaspring.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TweetSearchQueryTest {

    private final String EXPECTED_SEARCH_QUERY =
            "FROM:marketwatch OR FROM:wsj OR FROM:ft OR FROM:business OR FROM:theeconomist OR FROM:cnbc OR FROM:barronsonline";

    @Test
    void testQueryBuilder(){
        TweetSearchQuery tweetSearchQuery = new TweetSearchQuery(TickersAndSources.getSources());
        assertEquals(EXPECTED_SEARCH_QUERY,tweetSearchQuery.getQueryString());
    }

}