package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.components.StockQuotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class StockQuotesController {

    @Autowired
    StockQuotes stockQuotes;

    @GetMapping("api/quote")
    public String featuredStocksQuote() {
        return stockQuotes.getQuote();
    }


}
