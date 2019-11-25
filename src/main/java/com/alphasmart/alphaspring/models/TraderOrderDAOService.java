package com.alphasmart.alphaspring.models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class TraderOrderDAOService {

    @PersistenceContext
    private EntityManager entityManager;

    public Integer insert(TradeOrder tradeOrder){
        entityManager.persist(tradeOrder);
        return tradeOrder.getId();
    }

}
