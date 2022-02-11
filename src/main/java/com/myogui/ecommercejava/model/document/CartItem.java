package com.myogui.ecommercejava.model.document;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private String productCode;
    private Integer quantity;
    private Integer price;
}
