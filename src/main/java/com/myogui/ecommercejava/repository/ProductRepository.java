package com.myogui.ecommercejava.repository;

import com.myogui.ecommercejava.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByCode(Integer code);
    List<Product> findAllByCategory(String category);
    Product deleteByCode(Integer code);
}
