package com.myogui.ecommercejava.builder;

import com.myogui.ecommercejava.model.document.Product;
import com.myogui.ecommercejava.model.request.ProductRequest;
import com.myogui.ecommercejava.model.response.ProductResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductBuilder {
    //REQ -> DOC CREATE
    public static Product requestToDocumentCreate(ProductRequest request) {
        return Product.builder()
                .code(request.getCode())
                .name(request.getName())
                .price(request.getPrice())
                .category(request.getCategory())
                .stock(request.getStock())
                .creationDate(LocalDateTime.now())
                .status(Boolean.TRUE)
                .build();
    }

    //REQ -> DOC UPDATE
    public static Product requestToDocumentUpdate(ProductRequest request) {
        return Product.builder()
                .code(request.getCode())
                .name(request.getName())
                .price(request.getPrice())
                .category(request.getCategory())
                .stock(request.getStock())
                .modificationDate(LocalDateTime.now())
                .build();
    }

    public static ProductResponse documentToResponseUpdate(Product doc) {
        return ProductResponse.builder()
                .code(doc.getCode())
                .name(doc.getName())
                .category(doc.getCategory())
                .price(doc.getPrice())
                .stock(doc.getStock())
                .creationDate(doc.getCreationDate())
                .modificationDate(doc.getModificationDate())
                .status(doc.isStatus())
                .build();
    }

    //DOC -> RES CREATE
    public static ProductResponse documentToResponseCreate(Product document) {
        return ProductResponse.builder()
                .code(document.getCode())
                .creationDate(document.getCreationDate())
                .modificationDate(document.getModificationDate())
                .status(document.isStatus())
                .build();
    }

    //DOC -> RES SEARCH
    public static ProductResponse documentToResponseSearch(Product document) {
        return ProductResponse.builder()
                .code(document.getCode())
                .name(document.getName())
                .category(document.getCategory())
                .price(document.getPrice())
                .creationDate(document.getCreationDate())
                .status(document.isStatus())
                .build();
    }

    // DOC -> RES GENERICO
    public static <T extends Product> ProductResponse entityToResponse(T entity) {
        return ProductResponse.builder()
                .code(entity.getCode())
                .name(entity.getName())
                .category(entity.getCategory())
                .price(entity.getPrice())
                .stock(entity.getStock())
                .creationDate(entity.getCreationDate())
                .modificationDate(entity.getModificationDate())
                .status(entity.isStatus())
                .build();
    }

    // LIST<DOC> -> LIST<RES>
    public static List<ProductResponse> listProductToListResponse(List<Product> users) {
        var listResponse = new ArrayList<ProductResponse>();
        users.forEach(item -> listResponse.add(entityToResponse(item)));
        return listResponse;
    }
}
