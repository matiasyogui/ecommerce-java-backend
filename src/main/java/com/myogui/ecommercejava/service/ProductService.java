package com.myogui.ecommercejava.service;

import com.myogui.ecommercejava.model.document.Product;
import com.myogui.ecommercejava.model.exceptions.ApiRestException;
import com.myogui.ecommercejava.model.request.ProductRequest;
import com.myogui.ecommercejava.model.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest product);
    //Product getProductByCode(Integer code) throws ApiRestException;
    List<ProductResponse> getAllProducts();
    List<ProductResponse> getAllProductByCategory(String category) throws ApiRestException;
    ProductResponse updateProduct(Integer code, ProductRequest newProduct) throws ApiRestException;
    void deleteProductByCode(Integer code) throws ApiRestException;
}
