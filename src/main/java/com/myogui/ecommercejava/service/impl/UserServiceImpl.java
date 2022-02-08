package com.myogui.ecommercejava.service.impl;

import com.myogui.ecommercejava.builder.UserBuilder;
import com.myogui.ecommercejava.model.document.User;
import com.myogui.ecommercejava.model.exceptions.ApiRestException;
import com.myogui.ecommercejava.model.request.UserRequest;
import com.myogui.ecommercejava.model.response.UserResponse;
import com.myogui.ecommercejava.repository.UserRepository;
import com.myogui.ecommercejava.security.JwtProvider;
import com.myogui.ecommercejava.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder pwEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public UserResponse registerUser(UserRequest user) throws ApiRestException {
        if(repository.findByUsername(user.getUsername()) != null) {
            throw new ApiRestException("El usuario a crear ya existe.");
        }
        user.setPassword(pwEncoder.encode(user.getPassword()));
        var document = UserBuilder.requestToDocument(user);
        return UserBuilder.documentToResponse(repository.save(document));
    }

    @Override
    public UserResponse login(String username, String pw) throws ApiRestException {
        var user = repository.findByUsername(username);

        if(user == null || !pwEncoder.matches(pw, user.getPassword())) {
            throw new ApiRestException("Usuario o contraseña incorrecto.");
        }

        var userRes = UserBuilder.documentToResponse(user);
        userRes.setToken(jwtProvider.getJWTToken(username));
        return userRes;
    }
}
