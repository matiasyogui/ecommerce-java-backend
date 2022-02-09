package com.myogui.ecommercejava.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
    private Integer code;
    private String name;
    private String category;
    private Integer price;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private boolean status;
}
