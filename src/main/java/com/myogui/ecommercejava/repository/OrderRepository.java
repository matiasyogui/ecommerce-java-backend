package com.myogui.ecommercejava.repository;

import com.myogui.ecommercejava.model.document.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Integer> {
}
