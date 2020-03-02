package com.alphasmart.alphaspring.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TweetSearchQueryTest {

    @Test
    public void testQueryBuilder(){
        TweetSearchQuery tweetSearchQuery = new TweetSearchQuery(TickersAndSources.getSources());
        String EXPECTED_SEARCH_QUERY = "FROM:marketwatch OR FROM:wsj OR FROM:ft OR FROM:business OR FROM:theeconomist OR FROM:cnbc OR FROM:barronsonline";
        assertEquals(EXPECTED_SEARCH_QUERY,tweetSearchQuery.getQueryString());
    }

}