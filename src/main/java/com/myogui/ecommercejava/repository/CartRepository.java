package com.myogui.ecommercejava.repository;

import com.myogui.ecommercejava.model.document.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    Cart findByCartCode(Integer cartCode);
    Cart deleteByCartCode(Integer cartCode);
}
