package ru.trailblazers.musicappbackend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.trailblazers.musicappbackend.api.UserApi;
import ru.trailblazers.musicappbackend.dto.request.UserRequest;
import ru.trailblazers.musicappbackend.dto.response.UserResponse;
import ru.trailblazers.musicappbackend.service.UserService;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService service;

    @Override
    public UserResponse createUser(@Valid @RequestBody UserRequest request) {
        return service.addNewUser(request);
    }

    @Override
    public UserResponse getUserById(UUID userId) {
        return service.getUserById(userId);
    }

    @Override
    public List<UserResponse> getUsers() {
        return service.getUsers();
    }

    @Override
    public UserResponse updateUser(UUID userId, UserRequest request) {
        return service.updateUserById(userId, request);
    }

    @Override
    public void deleteUserById(UUID userId) {
        service.deleteUserById(userId);
    }
}
