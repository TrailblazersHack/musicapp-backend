package ru.trailblazers.musicappbackend.exception;

import java.util.UUID;

public class RoomNotFoundException extends NotFoundException {
    public RoomNotFoundException(UUID roomId) {
        super(String.format("Room with id = %s not found", roomId));
    }
}
