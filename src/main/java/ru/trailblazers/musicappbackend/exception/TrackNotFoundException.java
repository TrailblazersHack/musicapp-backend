package ru.trailblazers.musicappbackend.exception;

import java.util.UUID;

public class TrackNotFoundException extends NotFoundException {
    public TrackNotFoundException(UUID trackId) {
        super(String.format("Track with id = %s not found", trackId));
    }
}
