package com.myogui.ecommercejava.model.document;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private Integer productCode;
    private Integer quantity;
}
