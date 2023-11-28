package ru.trailblazers.musicappbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.trailblazers.musicappbackend.config.security.BaseUserDetails;
import ru.trailblazers.musicappbackend.dto.request.SignInRequest;
import ru.trailblazers.musicappbackend.dto.request.SignUpRequest;
import ru.trailblazers.musicappbackend.dto.response.JwtAuthResponse;
import ru.trailblazers.musicappbackend.entity.User;
import ru.trailblazers.musicappbackend.entity.enums.Status;
import ru.trailblazers.musicappbackend.exception.UserNotFoundException;
import ru.trailblazers.musicappbackend.repository.UserRepository;
import ru.trailblazers.musicappbackend.service.AuthService;
import ru.trailblazers.musicappbackend.service.JwtService;
import ru.trailblazers.musicappbackend.util.mapper.UserMapper;

import java.util.UUID;

import static ru.trailblazers.musicappbackend.entity.enums.Role.USER;
import static ru.trailblazers.musicappbackend.entity.enums.Status.CONFIRMED;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper mapper;

    @Override
    public JwtAuthResponse signUp(SignUpRequest request) {
        User user = mapper.toEntity(request);
        user.setId(UUID.randomUUID());
        user.setHashPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(USER);
        user.setStatus(CONFIRMED);
        repository.save(user);
        var jwt = jwtService.generateToken(new BaseUserDetails(user));
        return JwtAuthResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthResponse signIn(SignInRequest request) {
        var user = repository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException(request.getUsername()));
        if (!passwordEncoder.matches(request.getPassword(), user.getHashPassword())) {
            throw new RuntimeException("gay sex");
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword(), new BaseUserDetails(user).getAuthorities()));
        var jwt = jwtService.generateToken(new BaseUserDetails(user));
        return JwtAuthResponse.builder().token(jwt).build();
    }
}
