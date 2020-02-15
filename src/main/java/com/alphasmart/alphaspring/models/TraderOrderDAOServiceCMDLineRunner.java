package com.alphasmart.alphaspring.models;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


//@Component
public class TraderOrderDAOServiceCMDLineRunner implements CommandLineRunner {
    private static final Logger log = LogManager.getLogger(TraderOrderDAOServiceCMDLineRunner.class);

    @Autowired
    TraderOrderDAOService traderOrderDAOService;

    @Override
    public void run(String... args) throws Exception {
        TradeOrder tradeOrder = new TradeOrder("ABN","ABN AMRO BANK N.V.","Market Order",11.90,2000);
        Integer rslt =  traderOrderDAOService.insert(tradeOrder);
        log.info(String.valueOf(tradeOrder));
    }
}
