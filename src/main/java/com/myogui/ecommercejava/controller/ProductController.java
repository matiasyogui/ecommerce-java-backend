package com.myogui.ecommercejava.controller;

import com.myogui.ecommercejava.handle.ProductErrorHandle;
import com.myogui.ecommercejava.model.Product;
import com.myogui.ecommercejava.model.exceptions.ApiRestException;
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
    public Product newProduct(@Validated @RequestBody Product product) {
        return service.createProduct(product);
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{category}")
    public List<Product> getAllProductsByCategory(@PathVariable String category) throws ApiRestException {
        return service.getAllProductByCategory(category);
    }

/*    @GetMapping("/{code}")
    public Product getByCode(@PathVariable Integer code) throws ApiRestException {
        return service.getProductByCode(code);
    } */

    @PatchMapping("/{code}")
    public Product updateProduct(@PathVariable Integer code, @RequestBody @Validated Product newProduct) throws ApiRestException {
        return service.updateProduct(code, newProduct);
    }

    @DeleteMapping("/{code}")
    public Product delete(@PathVariable Integer code) throws ApiRestException {
        return service.deleteProductByCode(code);
    }
}
