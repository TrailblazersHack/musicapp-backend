package ru.trailblazers.musicappbackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.trailblazers.musicappbackend.dto.validation.constraint.TrackConstraint;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TrackConstraint
public class TrackRequest {
    private String title;
}
