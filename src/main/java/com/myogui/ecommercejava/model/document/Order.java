package com.myogui.ecommercejava.model.document;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("orders")
public class Order {
    private Integer number;
    private List<CartItem> productsList;
    private LocalDateTime creationDate;
    private String address;
    private boolean status;
    private String email;
}
