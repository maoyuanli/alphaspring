package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.components.FeaturedStocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class FeaturedStocksController {
    @Autowired
    FeaturedStocks featuredStocks;

    @RequestMapping(method = RequestMethod.GET, path = "api/quote")
    public String featuredStocksQuote() {
        return featuredStocks.GetQuote();
    }

}
