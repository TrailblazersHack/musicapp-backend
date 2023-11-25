package ru.trailblazers.musicappbackend.dto.response;

import ru.trailblazers.musicappbackend.entity.enums.Status;

import java.util.List;

public class RoomResponse {
    private String title;
    private UserResponse host;
    private Status status;
    private List<UserResponse> users;

}
