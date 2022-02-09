package com.myogui.ecommercejava.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myogui.ecommercejava.model.document.CartItem;
import com.myogui.ecommercejava.model.document.Product;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartResponse {
    private Integer cartCode;
    private String email;
    private String address;
    private LocalDateTime creationDate;
    private List<CartItem> cartList; //<ProductCode, Quantity>
}
