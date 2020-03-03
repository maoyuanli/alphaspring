package com.alphasmart.alphaspring.services;

import com.alphasmart.alphaspring.entities.TradeOrder;
import com.alphasmart.alphaspring.repositories.TraderOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeOrderService {

    private TraderOrderRepository traderOrderRepository;

    @Autowired
    public TradeOrderService(TraderOrderRepository traderOrderRepository) {
        this.traderOrderRepository = traderOrderRepository;
    }

    public TradeOrder save(TradeOrder tradeOrder){
        return traderOrderRepository.save(tradeOrder);
    }

    public List<TradeOrder> findAll(){
        return (List<TradeOrder>) traderOrderRepository.findAll();
    }
}
