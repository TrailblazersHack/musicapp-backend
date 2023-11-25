package ru.trailblazers.musicappbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.trailblazers.musicappbackend.dto.request.SignInRequest;
import ru.trailblazers.musicappbackend.dto.request.SignUpRequest;
import ru.trailblazers.musicappbackend.dto.response.JwtAuthResponse;
import ru.trailblazers.musicappbackend.entity.Role;
import ru.trailblazers.musicappbackend.entity.User;
import ru.trailblazers.musicappbackend.entity.enums.Status;
import ru.trailblazers.musicappbackend.repository.UserRepository;
import ru.trailblazers.musicappbackend.service.AuthService;
import ru.trailblazers.musicappbackend.service.JwtService;
import ru.trailblazers.musicappbackend.util.mapper.UserMapper;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper mapper;

    @Override
    @Transactional
    public JwtAuthResponse signup(SignUpRequest request) {
        User user = mapper.toEntity(request);
        user.setId(UUID.randomUUID());
        user.setHashPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        user.setStatus(Status.CONFIRMED);
        repository.save(user);
        var jwt = jwtService.generateToken((UserDetails) user);
        return JwtAuthResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken((UserDetails) user);
        return JwtAuthResponse.builder().token(jwt).build();
    }
}
