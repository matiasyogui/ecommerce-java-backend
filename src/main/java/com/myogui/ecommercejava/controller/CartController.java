package com.myogui.ecommercejava.controller;

import com.myogui.ecommercejava.model.document.Cart;
import com.myogui.ecommercejava.model.document.CartItem;
import com.myogui.ecommercejava.model.exceptions.ApiRestException;
import com.myogui.ecommercejava.model.request.CartRequest;
import com.myogui.ecommercejava.model.response.CartResponse;
import com.myogui.ecommercejava.repository.CartRepository;
import com.myogui.ecommercejava.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ecommerce")
public class CartController {
    private final CartService service;

    @PostMapping("/carrito")
    public CartResponse createCart(@RequestBody CartRequest cart) throws ApiRestException {
        return service.createCart(cart);
    }

    @PostMapping("/carrito/add/{cartCode}")
    public CartResponse addToCart(@PathVariable Integer cartCode, @RequestBody @Validated CartItem cartItem) throws ApiRestException {
        return service.addToCart(cartCode, cartItem);
    }

    @GetMapping("/carrito/{cartCode}")
    public CartResponse getACartByCartCode(@PathVariable Integer cartCode) throws ApiRestException {
        return service.getCartByCartCode(cartCode);
    }

    @DeleteMapping("/carrito/{cartCode}")
    public void deleteCartByCartCode(@PathVariable Integer cartCode) throws ApiRestException {
        service.deleteByCartcode(cartCode);
    }

    @PutMapping("/carrito/{cartCode}")
    public CartResponse updateByCartCode(@PathVariable Integer cartCode, @RequestBody CartRequest cart) throws ApiRestException {
        return service.updateByCartCode(cartCode, cart);
    }
}
