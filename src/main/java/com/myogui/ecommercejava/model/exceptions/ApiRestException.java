package com.myogui.ecommercejava.model.exceptions;

public class ApiRestException extends Exception {
    private String message;

    public ApiRestException(String message) {
        super(message);
    }
}
