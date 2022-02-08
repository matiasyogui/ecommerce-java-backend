package com.myogui.ecommercejava.controller;

import com.myogui.ecommercejava.model.exceptions.ApiRestException;
import com.myogui.ecommercejava.model.request.UserRequest;
import com.myogui.ecommercejava.model.response.UserResponse;
import com.myogui.ecommercejava.repository.UserRepository;
import com.myogui.ecommercejava.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ecommerce")
public class UserController {
    private final UserService service;

    @PostMapping("/register")
    public UserResponse register(@RequestBody @Validated UserRequest user) throws ApiRestException {
        return service.registerUser(user);
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody String username, @RequestBody String password) throws ApiRestException {
        return service.login(username, password);
    }
}
