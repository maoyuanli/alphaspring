package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.models.TradeOrder;
import com.alphasmart.alphaspring.models.TraderOrderRepository;
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
    @Autowired
    TraderOrderRepository traderOrderRepository;

    @GetMapping("api/getorder")
    public String getTradeOrder(){
        List<TradeOrder> orders = (List<TradeOrder>) traderOrderRepository.findAll();
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
        return traderOrderRepository.save(newTradeOrder);
    }

}
