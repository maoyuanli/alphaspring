package com.alphasmart.alphaspring.repositories;

import com.alphasmart.alphaspring.entities.TradeOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
class TraderOrderRepositoryIntegrationTest {

    @Autowired
    TraderOrderRepository traderOrderRepository;

    @Test
    public void ifNewTradeOrderSaved_thenSuccess(){
        traderOrderRepository.deleteAll();
        TradeOrder tradeOrder = new TradeOrder("Maotion Tech","Limited Buy","15.5","1000");
        traderOrderRepository.save(tradeOrder);
        assertEquals(1, ((List<TradeOrder>)traderOrderRepository.findAll()).size()); // initialized 3 in data.sql
        TradeOrder savedOrder = ((List<TradeOrder>) traderOrderRepository.findAll()).get(0);
        assertEquals("Maotion Tech", savedOrder.getTicker());
        assertEquals("Limited Buy", savedOrder.getOrderType());
        assertEquals("15.5", savedOrder.getOrderPrice());
        assertEquals("1000",savedOrder.getOrderVolumn());
    }

}