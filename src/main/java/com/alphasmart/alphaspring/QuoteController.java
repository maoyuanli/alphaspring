package com.alphasmart.alphaspring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.alphasmart.alphaspring.Quote;

@RestController
public class QuoteController {

    private String endPointUrl = "https://www.quandl.com/api/v3/datasets/EURONEXT/ADYEN.json?api_key=f_tQibQDxz8s2CABjKZU";
    @RequestMapping(method = RequestMethod.GET,path = "api/quote")
    public String GetQuote(){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(endPointUrl,String.class);
        return result;
    }

}
