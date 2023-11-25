package ru.trailblazers.musicappbackend.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateRoomRequest {
    private UUID userId;
    private String title;
}
