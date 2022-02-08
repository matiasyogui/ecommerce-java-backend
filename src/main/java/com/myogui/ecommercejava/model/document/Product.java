package com.myogui.ecommercejava.model.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("products")
public class Product {
    @Id
    private String id;
    private Integer code;
    private String name;
    private String category;
    private Integer price;
    private Integer stock;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private boolean status;
}
