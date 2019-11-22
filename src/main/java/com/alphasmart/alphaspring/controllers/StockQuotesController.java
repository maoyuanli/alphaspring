package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.components.StockQuotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class StockQuotesController {
    @Autowired
    StockQuotes stockQuotes;

    @RequestMapping(method = RequestMethod.GET, path = "api/quote")
    public String featuredStocksQuote() {
        return stockQuotes.GetQuote();
    }

}
