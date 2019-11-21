package com.alphasmart.alphaspring.components;

import com.alphasmart.alphaspring.controllers.FeaturedStocksController;
import com.alphasmart.alphaspring.models.Quote;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

@Component
public class FeaturedStocks {
    Logger log = LoggerFactory.getLogger(FeaturedStocksController.class);
    private String urlPrefix = "https://www.quandl.com/api/v3/datasets/EURONEXT/%s.json?api_key=f_tQibQDxz8s2CABjKZU&start_date=%s&end_date=%s";
    private ArrayList<String> tickers = new ArrayList<String>(Arrays.asList("ABN", "ADYEN", "INGA", "KPN", "RDSA", "BNP"));
    private ArrayList<String> startEndDate = startAndEndDate(1);
    private String startDate = startEndDate.get(0);
    private String endDate = startEndDate.get(1);

    public String GetQuote() {
        String quoteRsltStr = quotesBundler(tickers);
        return quoteRsltStr;
    }

    public String quotesBundler(ArrayList<String> tickers) {
        RestTemplate restTemplate = new RestTemplate();
        JsonArray quoteJsonArray = new JsonArray();
        for (int i = 0; i < tickers.size(); i++) {
            String quandlUrl = String.format(urlPrefix, tickers.get(i), startDate, endDate);
            Quote quote = restTemplate.getForObject(quandlUrl, Quote.class);
            Gson gson = new Gson();
            String quoteGson = gson.toJson(quote);
            JsonObject jsonResult = (JsonObject) new JsonParser().parse(quoteGson);
            quoteJsonArray.add(jsonResult);
        }
        JsonObject bundled = new JsonObject();
        bundled.add("quotes", quoteJsonArray);
        String quoteRsltStr = bundled.toString();
        return quoteRsltStr;
    }

    public static ArrayList<String> startAndEndDate(int yearAgo) {
        ArrayList<String> dateRangePair = new ArrayList<String>();
        Calendar cal = Calendar.getInstance();
        Date today = cal.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strToday = simpleDateFormat.format(today);
        cal.add(Calendar.YEAR, -yearAgo);
        Date oneYrAgo = cal.getTime();
        String strOneYrAgo = simpleDateFormat.format(oneYrAgo);
        dateRangePair.add(strOneYrAgo);
        dateRangePair.add(strToday);
        return dateRangePair;
    }
}
