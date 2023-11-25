package ru.trailblazers.musicappbackend.service;

import ru.trailblazers.musicappbackend.dto.request.UserRequest;
import ru.trailblazers.musicappbackend.dto.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserResponse addNewUser(UserRequest request);
    UserResponse updateUserById(UUID userId, UserRequest request);
    UserResponse getUserById(UUID userId);
    void deleteUserById(UUID userId);
    List<UserResponse> getUsers();
}
