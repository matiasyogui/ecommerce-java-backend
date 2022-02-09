package com.myogui.ecommercejava.service.impl;

import com.myogui.ecommercejava.builder.CartBuilder;
import com.myogui.ecommercejava.builder.ProductBuilder;
import com.myogui.ecommercejava.model.document.Cart;
import com.myogui.ecommercejava.model.document.CartItem;
import com.myogui.ecommercejava.model.document.Product;
import com.myogui.ecommercejava.model.exceptions.ApiRestException;
import com.myogui.ecommercejava.model.request.CartRequest;
import com.myogui.ecommercejava.model.response.CartResponse;
import com.myogui.ecommercejava.repository.CartRepository;
import com.myogui.ecommercejava.repository.ProductRepository;
import com.myogui.ecommercejava.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository repository;
    private final ProductRepository productRepository;

    @Override
    public CartResponse createCart(CartRequest cart) throws ApiRestException {
        if(repository.findByCartCode(cart.getCartCode()) != null) {
            throw new ApiRestException("Carrito ya existente");
        }
        var document = CartBuilder.requestToDocument(cart);
        return CartBuilder.documentToResponse(repository.save(document));
    }

    @Override
    public CartResponse addToCart(Integer cartCode, CartItem cartItem) throws ApiRestException {
        var cart = validateCartByCartCode(cartCode);
        var product = productRepository.findByCode(cartItem.getProductCode());
        if(Objects.isNull(product)) {
            throw new ApiRestException("Codigo de producto no existente.");
        }
        cart.getCartList().add(cartItem);
        return CartBuilder.documentToResponse(repository.save(cart));
    }

    @Override
    public CartResponse getCartByCartCode(Integer cartCode) throws ApiRestException {
        var cart = validateCartByCartCode(cartCode);
        return CartBuilder.documentToResponse(cart);
    }

    @Override
    public void deleteByCartcode(Integer cartCode) throws ApiRestException {
        var cart = validateCartByCartCode(cartCode);
        repository.delete(cart);
    }

    @Override
    public CartResponse updateByCartCode(Integer cartCode, CartRequest newCart) throws ApiRestException {
        var oldCart = validateCartByCartCode(cartCode);
        repository.deleteByCartCode(cartCode);

        Cart cartUpdated = CartBuilder.requestToDocument(newCart);
        cartUpdated.setCreationDate(oldCart.getCreationDate());
        return CartBuilder.documentToResponse(repository.save(cartUpdated));
    }


    public Cart validateCartByCartCode(Integer cartCode) throws ApiRestException {
        var cart = repository.findByCartCode(cartCode);
        if(Objects.isNull(cart)) {
            throw new ApiRestException("No existe el carrito con codigo " + cartCode + ".");
        }

        return cart;
    }
}
