package com.myogui.ecommercejava.service;

import com.myogui.ecommercejava.model.document.User;
import com.myogui.ecommercejava.model.document.UserForLogin;
import com.myogui.ecommercejava.model.exceptions.ApiRestException;
import com.myogui.ecommercejava.model.request.UserRequest;
import com.myogui.ecommercejava.model.response.UserResponse;

public interface UserService {
    UserResponse registerUser(UserRequest user) throws ApiRestException;
    String login(UserForLogin user) throws ApiRestException;
}
