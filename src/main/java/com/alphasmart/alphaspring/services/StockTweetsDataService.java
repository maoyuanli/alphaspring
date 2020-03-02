package com.alphasmart.alphaspring.services;

import com.alphasmart.alphaspring.utils.TickersAndSources;
import com.alphasmart.alphaspring.utils.TokenFetcher;
import com.alphasmart.alphaspring.utils.TweetSearchQuery;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

@Service
public class StockTweetsDataService {

    private static final Logger logger = LogManager.getLogger(StockTweetsDataService.class);

    @Autowired
    TweetSearchQuery tweetSearchQuery;

    public String tweetsList() {
        tweetSearchQuery.setSourceList(TickersAndSources.getSources());
        String queryStr = tweetSearchQuery.getQueryString();
        Twitter twitter = twitterInstance();
        Query query = new Query();
        query.count(100).setLang("en");
        query.setQuery(queryStr);
        String tweetRsltStr = null;
        try {
            QueryResult result = twitter.search(query);
            List<Status> statuses = result.getTweets();
            Gson gson = new Gson();
            String tweets = gson.toJson(statuses);
            JsonArray tweetsJson = (JsonArray) new JsonParser().parse(tweets);
            JsonObject tweetWrapped = new JsonObject();
            tweetWrapped.add("tweets", tweetsJson);
            tweetRsltStr = tweetWrapped.toString();
        } catch (TwitterException e) {
            logger.info(e.getMessage());
        }
        return tweetRsltStr;
    }


    public static Twitter twitterInstance() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        TokenFetcher tokenFetcher = new TokenFetcher("token.json");

        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(tokenFetcher.fetchToken("api_key"))
                .setOAuthConsumerSecret(tokenFetcher.fetchToken("api_secret"))
                .setOAuthAccessToken(tokenFetcher.fetchToken("access_token"))
                .setOAuthAccessTokenSecret(tokenFetcher.fetchToken("access_secret"));
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }

}
