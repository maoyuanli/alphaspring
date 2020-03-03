package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.entities.TradeOrder;
import com.alphasmart.alphaspring.services.TradeOrderService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TradeOrderController {

    private TradeOrderService tradeOrderService;

    @Autowired
    public TradeOrderController(TradeOrderService tradeOrderService) {
        this.tradeOrderService = tradeOrderService;
    }

    @GetMapping("api/getorder")
    public String getTradeOrder(){
        List<TradeOrder> orders = tradeOrderService.findAll();
        Gson gson = new Gson();
        String ordersStr = gson.toJson(orders);
        JsonArray orderJsonArr = (JsonArray) new JsonParser().parse(ordersStr);
        JsonObject orderWrapped = new JsonObject();
        orderWrapped.add("orders", orderJsonArr);
        String orderStrRslt = orderWrapped.toString();
        return orderStrRslt;
    }

    @PostMapping("api/setorder")
    public TradeOrder newTradeOrder(@RequestBody TradeOrder newTradeOrder){
        return tradeOrderService.save(newTradeOrder);
    }

}
