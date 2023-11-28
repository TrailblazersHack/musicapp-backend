package ru.trailblazers.musicappbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.trailblazers.musicappbackend.api.AuthApi;
import ru.trailblazers.musicappbackend.dto.request.SignInRequest;
import ru.trailblazers.musicappbackend.dto.request.SignUpRequest;
import ru.trailblazers.musicappbackend.dto.response.JwtAuthResponse;
import ru.trailblazers.musicappbackend.service.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    private final AuthService authService;

    @Override
    public JwtAuthResponse signUp(SignUpRequest request) {
        return authService.signUp(request);
    }

    @Override
    public JwtAuthResponse signIn(SignInRequest request) {
        return authService.signIn(request);
    }
}
