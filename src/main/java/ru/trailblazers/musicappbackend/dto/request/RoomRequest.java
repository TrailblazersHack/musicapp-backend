package ru.trailblazers.musicappbackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.trailblazers.musicappbackend.dto.validation.constraint.RoomConstraint;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RoomConstraint
public class RoomRequest {
    private UUID userId;
    private String title;
}
