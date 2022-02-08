package com.myogui.ecommercejava.model.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private Integer code;
    private String name;
    private String category;
    private Integer price;
    private Integer stock;
}
