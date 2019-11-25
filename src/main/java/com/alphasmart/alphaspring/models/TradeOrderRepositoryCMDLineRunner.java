package com.alphasmart.alphaspring.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class TradeOrderRepositoryCMDLineRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(TradeOrderRepositoryCMDLineRunner.class);

    @Autowired
    TraderOrderRepository traderOrderRepository;

    @Override
    public void run(String... args) throws Exception {
        TradeOrder tradeOrder = new TradeOrder("INGA","ING Groupe","Limited Order",210.00,85000);
        traderOrderRepository.save(tradeOrder);
        List<TradeOrder> tradeorders = traderOrderRepository.findAll();
        log.info(String.valueOf(tradeorders));
    }
}
