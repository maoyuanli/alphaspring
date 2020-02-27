package com.alphasmart.alphaspring.repositories;

import com.alphasmart.alphaspring.entities.TradeOrder;
import org.springframework.data.repository.CrudRepository;

public interface TraderOrderRepository extends CrudRepository<TradeOrder, Long> {
}
