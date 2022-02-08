package com.myogui.ecommercejava.controller;

import com.myogui.ecommercejava.model.document.Product;
import com.myogui.ecommercejava.model.exceptions.ApiRestException;
import com.myogui.ecommercejava.model.request.ProductRequest;
import com.myogui.ecommercejava.model.response.ProductResponse;
import com.myogui.ecommercejava.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productos")
public class ProductController {
    private final ProductService service;

    @PostMapping("")
    public ProductResponse newProduct(@Validated @RequestBody ProductRequest product) {
        return service.createProduct(product);
    }

    @GetMapping("")
    public List<ProductResponse> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{category}")
    public List<ProductResponse> getAllProductsByCategory(@PathVariable String category) throws ApiRestException {
        return service.getAllProductByCategory(category);
    }

/*    @GetMapping("/{code}")
    public Product getByCode(@PathVariable Integer code) throws ApiRestException {
        return service.getProductByCode(code);
    } */

    @PatchMapping("/{code}")
    public ProductResponse updateProduct(@PathVariable Integer code, @RequestBody @Validated ProductRequest newProduct) throws ApiRestException {
        return service.updateProduct(code, newProduct);
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable Integer code) throws ApiRestException {
        service.deleteProductByCode(code);
    }
}
