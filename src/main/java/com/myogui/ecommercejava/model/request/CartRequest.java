package com.myogui.ecommercejava.model.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartRequest {
    private Integer cartCode;
    private String email;
    private String address;
}
