package com.alphasmart.alphaspring.components;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.xml.bind.v2.TODO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import twitter4j.Query;
import twitter4j.QueryResult;

import twitter4j.Status;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import twitter4j.conf.ConfigurationBuilder;

@Component
public class StockTweets {

    public String tweetsList() {
        String queryStr = tweetQueryBuilder();
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
            //ToDo
        }
        return tweetRsltStr;
    }

    public static String tweetQueryBuilder() {

        String fromPrefix = "FROM:";
        String orPrefix = " OR ";
        StringBuilder query = new StringBuilder();
        ArrayList<String> sources = TickersAndSources.getSources();
        for (int i = 0; i < sources.size(); i++) {
            if (!(i == sources.size() - 1)) {
                query.append(fromPrefix).append(sources.get(i)).append(orPrefix);
            } else {
                query.append(fromPrefix).append(sources.get(i));
            }
        }

        return query.toString();
    }


    public static Twitter twitterInstance() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("BhUKZxdqhPEylXHSG4dXl42TB")
                .setOAuthConsumerSecret("oxo2R7n47xBVnvyjojZuYfg4AfX7R7NgUPYNyZBQi8JsoUfjHs")
                .setOAuthAccessToken("3225745957-jwvwQAWknVkZDSuHjwTDHcZIglDICUYZtSbjX9i")
                .setOAuthAccessTokenSecret("bhC6p8Q5niKg5zQpx6JTqTFWepeeSMBq8JsNscorfoNgk");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        return twitter;
    }

}
