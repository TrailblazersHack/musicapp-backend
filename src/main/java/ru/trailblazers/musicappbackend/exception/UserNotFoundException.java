package ru.trailblazers.musicappbackend.exception;

import java.util.UUID;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException(UUID userId) {
        super(String.format("User with id = %s not found", userId));
    }

    public UserNotFoundException(String username) {
        super(String.format("User with username = %s not found", username));
    }
}
