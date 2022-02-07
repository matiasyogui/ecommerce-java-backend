package com.myogui.ecommercejava.service.impl;

import com.myogui.ecommercejava.model.Product;
import com.myogui.ecommercejava.model.exceptions.ApiRestException;
import com.myogui.ecommercejava.repository.ProductRepository;
import com.myogui.ecommercejava.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product getProductByCode(Integer code) throws ApiRestException {
        var product = repository.findByCode(code);
        if(Objects.isNull(product)) {
            throw new ApiRestException("Product code not found.");
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public List<Product> getAllProductByCategory(String category) throws ApiRestException {
        var products = repository.findAllByCategory(category);
        if(Objects.isNull(products)) {
            throw new ApiRestException("Category not found.");
        }
        return products;
    }

    @Override
    public Product updateProduct(Integer code, Product newProduct) throws ApiRestException {
        if(Objects.isNull(repository.findByCode(code))) {
            throw new ApiRestException("Product code not found.");
        }
        repository.deleteByCode(code);
        newProduct.setCode(code);
        return repository.save(newProduct);
    }

    @Override
    public Product deleteProductByCode(Integer code) throws ApiRestException {
        if(Objects.isNull(repository.findByCode(code))) {
            throw new ApiRestException("Product code not found.");
        }
        return repository.deleteByCode(code);
    }
}
