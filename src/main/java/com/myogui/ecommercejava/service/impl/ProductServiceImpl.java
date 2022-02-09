package com.myogui.ecommercejava.service.impl;

import com.myogui.ecommercejava.builder.ProductBuilder;
import com.myogui.ecommercejava.model.document.Product;
import com.myogui.ecommercejava.model.exceptions.ApiRestException;
import com.myogui.ecommercejava.model.request.ProductRequest;
import com.myogui.ecommercejava.model.response.ProductResponse;
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
    public ProductResponse createProduct(ProductRequest productReq) throws ApiRestException {
        if(repository.findByCode(productReq.getCode()) != null) {
            throw new ApiRestException("Codigo de producto ya creado.");
        }
        var document = repository.save(ProductBuilder.requestToDocumentCreate(productReq));
        return ProductBuilder.documentToResponseCreate(document);
    }
/*
    @Override
    public ProductResponse getProductByCode(Integer code) throws ApiRestException {
        var product = repository.findByCode(code);
        if(Objects.isNull(product)) {
            throw new ApiRestException("Product code not found.");
        }
        return product;
    }
 */

    @Override
    public List<ProductResponse> getAllProducts() {
        return ProductBuilder.listProductToListResponse(repository.findAll());
    }

    @Override
    public List<ProductResponse> getAllProductByCategory(String category) throws ApiRestException {
        var products = repository.findAllByCategory(category);
        if(products.isEmpty()) {
            throw new ApiRestException("Category not found.");
        }
        return ProductBuilder.listProductToListResponse(products);
    }

    @Override
    public ProductResponse updateProduct(Integer code, ProductRequest newProduct) throws ApiRestException {
        var previousProduct = repository.findByCode(code);
        if(Objects.isNull(previousProduct)) {
            throw new ApiRestException("Product code not found.");
        }
        repository.deleteByCode(code);
        Product productUpdated = ProductBuilder.requestToDocumentUpdate(newProduct);
        productUpdated.setCreationDate(previousProduct.getCreationDate());
        return ProductBuilder.documentToResponseUpdate(repository.save(productUpdated));
    }

    @Override
    public void deleteProductByCode(Integer code) throws ApiRestException {
        if(Objects.isNull(repository.findByCode(code))) {
            throw new ApiRestException("Product code not found.");
        }
        repository.deleteByCode(code);
    }
}
