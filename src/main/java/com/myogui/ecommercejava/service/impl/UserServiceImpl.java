package com.myogui.ecommercejava.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.myogui.ecommercejava.builder.UserBuilder;
import com.myogui.ecommercejava.cache.CacheUser;
import com.myogui.ecommercejava.model.document.User;
import com.myogui.ecommercejava.model.document.UserForLogin;
import com.myogui.ecommercejava.model.exceptions.ApiRestException;
import com.myogui.ecommercejava.model.request.UserRequest;
import com.myogui.ecommercejava.model.response.UserResponse;
import com.myogui.ecommercejava.repository.UserRepository;
import com.myogui.ecommercejava.security.JwtProvider;
import com.myogui.ecommercejava.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder pwEncoder;
    private final JwtProvider jwtProvider;
    private final CacheUser<User> cache;

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
    public String login(UserForLogin user) throws ApiRestException {
        var tokenFromCache = cache.recover(user.getUsername());
        if (!Objects.isNull(tokenFromCache)) {
            return tokenFromCache;
        }

        var userFromDatabase = repository.findByUsername(user.getUsername());
        if(userFromDatabase == null || !pwEncoder.matches(user.getPassword(), userFromDatabase.getPassword())) {
            throw new ApiRestException("Usuario o contraseña incorrecto.");
        }
        return saveUserInCache(user.getUsername(), jwtProvider.getJWTToken(user.getUsername()));
    }

    public String saveUserInCache(String username, String token) {
        return cache.save(username, token);
    }
}
