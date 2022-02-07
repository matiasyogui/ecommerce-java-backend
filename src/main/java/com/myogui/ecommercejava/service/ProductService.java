package com.myogui.ecommercejava.service;

import com.myogui.ecommercejava.model.Product;
import com.myogui.ecommercejava.model.exceptions.ApiRestException;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductByCode(Integer code) throws ApiRestException;
    List<Product> getAllProducts();
    List<Product> getAllProductByCategory(String category) throws ApiRestException;
    Product updateProduct(Integer code, Product newProduct) throws ApiRestException;
    Product deleteProductByCode(Integer code) throws ApiRestException;
}
