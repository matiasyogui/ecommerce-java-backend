package com.myogui.ecommercejava.service;

import com.myogui.ecommercejava.model.document.Order;

public interface EmailSender {
    public void sendEmailTo(Order order);
}
