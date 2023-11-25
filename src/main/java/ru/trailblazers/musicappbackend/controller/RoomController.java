package ru.trailblazers.musicappbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.trailblazers.musicappbackend.api.RoomApi;
import ru.trailblazers.musicappbackend.dto.request.RoomRequest;
import ru.trailblazers.musicappbackend.dto.response.RoomResponse;
import ru.trailblazers.musicappbackend.service.RoomService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class RoomController implements RoomApi {

    private final RoomService service;
    
    @Override
    public RoomResponse createRoom(RoomRequest request) {
        return null;
    }

    @Override
    public RoomResponse getRoomById(UUID roomId) {
        return null;
    }

    @Override
    public List<RoomResponse> getRooms() {
        return null;
    }

    @Override
    public RoomResponse updateRoom(UUID roomId, RoomRequest request) {
        return null;
    }

    @Override
    public void deleteRoomById(UUID roomId) {

    }
}
