package ru.trailblazers.musicappbackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.trailblazers.musicappbackend.dto.request.TrackRequest;
import ru.trailblazers.musicappbackend.dto.response.TrackResponse;
import ru.trailblazers.musicappbackend.service.TrackService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

    @Override
    public TrackResponse addNewTrack(TrackRequest request) {
        return null;
    }

    @Override
    public TrackResponse updateTrackById(UUID trackId, TrackRequest request) {
        return null;
    }

    @Override
    public TrackResponse getTrackById(UUID trackId) {
        return null;
    }

    @Override
    public void deleteTrackById(UUID trackId) {

    }

    @Override
    public List<TrackResponse> getTracks() {
        return null;
    }
}
