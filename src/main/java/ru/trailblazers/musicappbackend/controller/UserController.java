package ru.trailblazers.musicappbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.trailblazers.musicappbackend.api.UserApi;
import ru.trailblazers.musicappbackend.dto.request.UserRequest;
import ru.trailblazers.musicappbackend.dto.response.UserResponse;
import ru.trailblazers.musicappbackend.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService service;

    @Override
    @PostMapping()
    public UserResponse createUser(UserRequest request) {
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
