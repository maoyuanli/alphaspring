package com.alphasmart.alphaspring;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@CrossOrigin(origins = "*")
public class QuoteController {
    final String apiKey = "f_tQibQDxz8s2CABjKZU";
    final String urlPrefix = "https://www.quandl.com/api/v3/datasets/EURONEXT/%s.json?api_key=f_tQibQDxz8s2CABjKZU";

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
            String quandlUrl = String.format(urlPrefix, tickers.get(i));
            String strResult = restTemplate.getForObject(quandlUrl, String.class);
            JsonObject jsonResult = (JsonObject) new JsonParser().parse(strResult);
            quoteJsonArray.add(jsonResult);
        }

        String quoteRsltStr = "{" + "\"quotes\":" + quoteJsonArray.toString() + "}";
        return quoteRsltStr;

    }
}
