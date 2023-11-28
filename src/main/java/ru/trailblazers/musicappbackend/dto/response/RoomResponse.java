package ru.trailblazers.musicappbackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.trailblazers.musicappbackend.entity.enums.Status;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomResponse {
    private String title;
    private UserResponse host;
    private Status status;
    private List<UserResponse> users;

}
