package com.alphasmart.alphaspring;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
public class QuoteController {
    Logger log = LoggerFactory.getLogger(QuoteController.class);
    final String apiKey = "f_tQibQDxz8s2CABjKZU";
    private String urlPrefix = "https://www.quandl.com/api/v3/datasets/EURONEXT/%s.json?api_key=f_tQibQDxz8s2CABjKZU&start_date=%s&end_date=%s";
    private ArrayList<String> startEndDate = startAndEndDate(1);
    private String startDate = startEndDate.get(0);
    private String endDate = startEndDate.get(1);

    @RequestMapping(method = RequestMethod.GET, path = "api/quote")
    public String GetQuote() {
        ArrayList<String> tickers = new ArrayList<String>(Arrays.asList("ABN", "ADYEN", "INGA", "KPN", "RDSA", "BNP"));
        String quoteRsltStr = quotesBundler(tickers);
        return quoteRsltStr;
    }

    public String quotesBundler(ArrayList<String> tickers) {
        RestTemplate restTemplate = new RestTemplate();
        JsonArray quoteJsonArray = new JsonArray();
        for (int i = 0; i < tickers.size(); i++) {
            String quandlUrl = String.format(urlPrefix, tickers.get(i),startDate,endDate);
            Quote quote = restTemplate.getForObject(quandlUrl, Quote.class);
//            log.info(quote.toString());
            Gson gson = new Gson();
            String quoteGson = gson.toJson(quote);
//            log.info(quoteGson);
            JsonObject jsonResult = (JsonObject) new JsonParser().parse(quoteGson);
            quoteJsonArray.add(jsonResult);
        }
        log.info("quoteJsonArray.toString() : \n "+quoteJsonArray.toString());
        JsonObject bundled = new JsonObject();
        bundled.addProperty("quotes",quoteJsonArray.toString());
        String quoteRsltStr = bundled.toString();
//        log.info(quoteRsltStr);
        return quoteRsltStr;
    }

    public static ArrayList<String> startAndEndDate(int yearAgo){
        ArrayList<String> dateRangePair = new ArrayList<String>();
        Calendar cal = Calendar.getInstance();
        Date today = cal.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strToday = simpleDateFormat.format(today);
        cal.add(Calendar.YEAR,-yearAgo);
        Date oneYrAgo = cal.getTime();
        String strOneYrAgo = simpleDateFormat.format(oneYrAgo);
        dateRangePair.add(strOneYrAgo);
        dateRangePair.add(strToday);
        return dateRangePair;
    }
}
