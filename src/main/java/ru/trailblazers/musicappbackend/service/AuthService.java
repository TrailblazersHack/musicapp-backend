package ru.trailblazers.musicappbackend.service;

import ru.trailblazers.musicappbackend.dto.request.SignInRequest;
import ru.trailblazers.musicappbackend.dto.request.SignUpRequest;
import ru.trailblazers.musicappbackend.dto.response.JwtAuthResponse;

public interface AuthService {
    JwtAuthResponse signUp(SignUpRequest request);
    JwtAuthResponse signIn(SignInRequest request);
}
