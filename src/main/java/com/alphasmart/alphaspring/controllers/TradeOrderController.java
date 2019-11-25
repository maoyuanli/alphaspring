package com.alphasmart.alphaspring.controllers;

import com.alphasmart.alphaspring.models.TradeOrder;
import com.alphasmart.alphaspring.models.TraderOrderRepository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TradeOrderController {
    @Autowired
    TraderOrderRepository traderOrderRepository;

    @RequestMapping(method = RequestMethod.GET, path = "api/getorder")
    public String getTradeOrder(){
        List<TradeOrder> orders = traderOrderRepository.findAll();
        Gson gson = new Gson();
        String ordersStr = gson.toJson(orders);
        JsonArray orderJsonArr = (JsonArray) new JsonParser().parse(ordersStr);
        JsonObject orderWrapped = new JsonObject();
        orderWrapped.add("orders", orderJsonArr);
        String orderStrRslt = orderWrapped.toString();
        return orderStrRslt;
    }

    @RequestMapping(method = RequestMethod.POST, path = "api/setorder")
    public String setTradeOrder(ModelMap model, @Valid TradeOrder tradeOrder, BindingResult result){
        traderOrderRepository.save(tradeOrder);
        return String.valueOf(tradeOrder);
    }

}
