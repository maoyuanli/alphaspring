package com.alphasmart.alphaspring.services;

import com.alphasmart.alphaspring.entities.Quote;
import com.alphasmart.alphaspring.utils.DateRangeProvider;
import com.alphasmart.alphaspring.utils.TickersAndSources;
import com.alphasmart.alphaspring.utils.TokenFetcher;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class StockQuotesDataService {

    private DateRangeProvider dateRangeProvider;

    @Autowired
    public StockQuotesDataService(DateRangeProvider dateRangeProvider) {
        this.dateRangeProvider = dateRangeProvider;
    }

    public String getQuote() {
        return quotesBundler();
    }

    public String quotesBundler() {
        TokenFetcher tokenFetcher = new TokenFetcher("token.json");
        String QUANDL_TOKEN = tokenFetcher.fetchToken("quandl_key");
        String QUANDL_API_URL = "https://www.quandl.com/api/v3/datasets/EURONEXT/%s.json?api_key=%s&start_date=%s&end_date=%s";
        ArrayList<String> tickers = TickersAndSources.getTickers();
        List<String> startEndDate = dateRangeProvider.startAndEndDate(1);
        String startDate = startEndDate.get(0);
        String endDate = startEndDate.get(1);
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

}
