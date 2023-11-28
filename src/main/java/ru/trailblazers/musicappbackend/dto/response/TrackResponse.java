package ru.trailblazers.musicappbackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackResponse {
    private UUID id;
    private String title;
    private Long duration;
    private String url;
}
