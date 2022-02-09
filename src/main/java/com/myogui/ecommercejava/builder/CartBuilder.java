package com.myogui.ecommercejava.builder;

import com.myogui.ecommercejava.model.document.Cart;
import com.myogui.ecommercejava.model.document.User;
import com.myogui.ecommercejava.model.request.CartRequest;
import com.myogui.ecommercejava.model.request.UserRequest;
import com.myogui.ecommercejava.model.response.CartResponse;
import com.myogui.ecommercejava.model.response.UserResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CartBuilder {
    // REQ -> DOC
    public static Cart requestToDocument(CartRequest request) {
        return Cart.builder()
                .cartCode(request.getCartCode())
                .address(request.getAddress())
                .email(request.getEmail())
                .creationDate(LocalDateTime.now())
                .cartList(new ArrayList<>())
                .build();
    }

    // DOC -> RES
    public static CartResponse documentToResponse(Cart cart) {
        return CartResponse.builder()
                .cartCode(cart.getCartCode())
                .email(cart.getEmail())
                .address(cart.getAddress())
                .creationDate(cart.getCreationDate())
                .cartList(cart.getCartList())
                .build();
    }
}
