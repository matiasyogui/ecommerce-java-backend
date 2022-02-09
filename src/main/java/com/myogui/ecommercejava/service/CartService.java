package com.myogui.ecommercejava.service;

import com.myogui.ecommercejava.model.document.Cart;
import com.myogui.ecommercejava.model.document.CartItem;
import com.myogui.ecommercejava.model.exceptions.ApiRestException;
import com.myogui.ecommercejava.model.request.CartRequest;
import com.myogui.ecommercejava.model.response.CartResponse;

public interface CartService {
    CartResponse addToCart(Integer cartCode, CartItem cartItem) throws ApiRestException;
    CartResponse createCart(CartRequest cart) throws ApiRestException;

    CartResponse getCartByCartCode(Integer cartCode) throws ApiRestException;

    void deleteByCartcode(Integer cartCode) throws ApiRestException;

    CartResponse updateByCartCode(Integer cartCode, CartRequest cart) throws ApiRestException;
}
