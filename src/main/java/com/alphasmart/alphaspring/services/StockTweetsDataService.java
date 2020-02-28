package com.alphasmart.alphaspring.services;

import java.util.HashMap;
import java.util.List;

import com.alphasmart.alphaspring.utils.TickersAndSources;
import com.alphasmart.alphaspring.utils.TokenFetcher;
import com.alphasmart.alphaspring.utils.TweetSearchQuery;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import twitter4j.Query;
import twitter4j.QueryResult;

import twitter4j.Status;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import twitter4j.conf.ConfigurationBuilder;

@Component
public class StockTweetsDataService {
    private static final Logger logger = LogManager.getLogger(StockTweetsDataService.class);

    private static TweetSearchQuery query = new TweetSearchQuery(TickersAndSources.getSources());
    private static String queryStr = query.getQueryString();

    public String tweetsList() {
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
        TokenFetcher tokenFetcher = new TokenFetcher();
        HashMap<String, String> twitterTokens = tokenFetcher.fetchToken("token.json");

        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(twitterTokens.get("api_key"))
                .setOAuthConsumerSecret(twitterTokens.get("api_secret"))
                .setOAuthAccessToken(twitterTokens.get("access_token"))
                .setOAuthAccessTokenSecret(twitterTokens.get("access_secret"));
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }

}