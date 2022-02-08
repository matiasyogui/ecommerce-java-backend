package com.myogui.ecommercejava.builder;

import com.myogui.ecommercejava.model.document.User;
import com.myogui.ecommercejava.model.request.UserRequest;
import com.myogui.ecommercejava.model.response.UserResponse;

import java.time.LocalDateTime;

public class UserBuilder {
    // REQ -> DOC
    public static User requestToDocument(UserRequest request) {
        return User.builder()
                .fullName(request.getFullName())
                .telephone(request.getTelephone())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .creationDate(LocalDateTime.now())
                .build();
    }

    // DOC -> RES
    public static UserResponse documentToResponse(User user) {
        return UserResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .creationDate(user.getCreationDate())
                .build();
    }
}
