package ru.trailblazers.musicappbackend.dto.request;

import lombok.Data;

@Data
public class RoomRequest {
    private String title;
    private Integer limitUsers;
    private Boolean privacy;
}
