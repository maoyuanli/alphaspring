package com.alphasmart.alphaspring.services;

import com.alphasmart.alphaspring.entities.Quote;
import com.alphasmart.alphaspring.utils.TickersAndSources;
import com.alphasmart.alphaspring.utils.TokenFetcher;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


@Service
public class StockQuotesDataService {
    TokenFetcher tokenFetcher = new TokenFetcher("token.json");
    private final String QUANDL_TOKEN = tokenFetcher.fetchToken("quandl_key");
    private final String QUANDL_API_URL = "https://www.quandl.com/api/v3/datasets/EURONEXT/%s.json?api_key=%s&start_date=%s&end_date=%s";
    private ArrayList<String> tickers = TickersAndSources.getTickers();
    private ArrayList<String> startEndDate = startAndEndDate(1);
    private String startDate = startEndDate.get(0);
    private String endDate = startEndDate.get(1);

    public String getQuote() {
        return quotesBundler(tickers);
    }

    public String quotesBundler(ArrayList<String> tickers) {
        RestTemplate restTemplate = new RestTemplate();
        JsonArray quoteJsonArray = new JsonArray();
        tickers.forEach(ticker -> {
            String quandlUrl = String.format(QUANDL_API_URL, ticker, QUANDL_TOKEN, startDate, endDate);
            Quote quote = restTemplate.getForObject(quandlUrl, Quote.class);
            Gson gson = new Gson();
            String quoteGson = gson.toJson(quote);
            JsonObject jsonResult = (JsonObject) new JsonParser().parse(quoteGson);
            quoteJsonArray.add(jsonResult);
        });
        JsonObject bundled = new JsonObject();
        bundled.add("quotes", quoteJsonArray);
        return bundled.toString();
    }

    public ArrayList<String> startAndEndDate(long yearAgo) {
        ArrayList<String> dateRangePair = new ArrayList<String>();
        LocalDate today = getToday();
        String strToday = today.format(DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate oneYrAgo = today.minusYears(yearAgo);
        String strOneYrAgo = oneYrAgo.format(DateTimeFormatter.ISO_LOCAL_DATE);
        dateRangePair.add(strOneYrAgo);
        dateRangePair.add(strToday);
        return dateRangePair;
    }

    public LocalDate getToday() {
        return LocalDate.now();
    }
}
