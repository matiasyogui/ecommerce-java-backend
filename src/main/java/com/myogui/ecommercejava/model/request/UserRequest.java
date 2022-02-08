package com.myogui.ecommercejava.model.request;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String fullName;
    private Integer telephone;
    private String username;
    private String password;
    private String email;
}
