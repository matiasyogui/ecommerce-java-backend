package com.myogui.ecommercejava.model.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("cart")
public class Cart {
    @Id
    private String id;
    private Integer cartCode;
    private String email;
    private LocalDateTime creationDate;
    private String address;
    private List<CartItem> cartList; //<ProdCode, Quantity>
}
