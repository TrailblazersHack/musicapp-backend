package ru.trailblazers.musicappbackend.service;

import ru.trailblazers.musicappbackend.dto.request.TrackRequest;
import ru.trailblazers.musicappbackend.dto.response.TrackResponse;

import java.util.List;
import java.util.UUID;

public interface TrackService {
    TrackResponse addNewTrack(TrackRequest request);
    TrackResponse updateTrackById(UUID trackId, TrackRequest request);
    TrackResponse getTrackById(UUID trackId);
    void deleteTrackById(UUID trackId);
    List<TrackResponse> getTracks();
}
