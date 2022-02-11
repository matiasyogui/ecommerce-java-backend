package com.myogui.ecommercejava.controller;

import com.myogui.ecommercejava.model.document.UserForLogin;
import com.myogui.ecommercejava.model.exceptions.ApiRestException;
import com.myogui.ecommercejava.model.request.UserRequest;
import com.myogui.ecommercejava.model.response.UserResponse;
import com.myogui.ecommercejava.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ecommerce")
public class UserController {
    private final UserService service;

    @PostMapping("/register")
    public UserResponse register(@RequestBody @Validated UserRequest user) throws ApiRestException {
        return service.registerUser(user);
    }

    @PostMapping("/login") //devuelve un jwttoken.
    public String login(@RequestBody UserForLogin user) throws ApiRestException {
        return service.login(user);
    }
}
