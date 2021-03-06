package com.myogui.ecommercejava.service.impl;

import com.myogui.ecommercejava.model.document.CartItem;
import com.myogui.ecommercejava.model.document.Order;
import com.myogui.ecommercejava.service.EmailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailSender {
    private final JavaMailSender javaMailSender;

    @Override
    public void sendEmailTo(Order order) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(order.getEmail());
        msg.setSubject("La orden numero " + order.getNumber() + " ha sido enviada a " + order.getAddress() + ".");


        msg.setText("La orden creada el " + String.valueOf(order.getCreationDate()) + " con: \n" +
                listOfProductsToString(order.getProductsList()) + "\n Saludos!");

        javaMailSender.send(msg);
    }

    public String texto(CartItem cartItem) {
        return cartItem.getProductCode() + ". Cant: " + cartItem.getQuantity() + ". Precio: " + cartItem.getPrice() + " \n";
    }

    public String listOfProductsToString(List<CartItem> cartList) {
        int total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(CartItem i : cartList) {
            stringBuilder.append(texto(i));
            total += i.getPrice() * i.getQuantity();
        }

        stringBuilder.append("Total: ").append(total).append(".\n");

        return stringBuilder.toString();
    }
}
