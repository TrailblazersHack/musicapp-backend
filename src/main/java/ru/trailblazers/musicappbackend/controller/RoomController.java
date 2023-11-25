package ru.trailblazers.musicappbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.trailblazers.musicappbackend.api.RoomApi;
import ru.trailblazers.musicappbackend.dto.request.CreateRoomRequest;
import ru.trailblazers.musicappbackend.dto.request.RoomRequest;
import ru.trailblazers.musicappbackend.dto.request.UserRequest;
import ru.trailblazers.musicappbackend.dto.response.RoomResponse;
import ru.trailblazers.musicappbackend.service.RoomService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class RoomController implements RoomApi {

    private final RoomService service;

    @Override
    public RoomResponse createRoom(CreateRoomRequest roomRequest) {
        return service.addNewRoom(roomRequest);
    }

    @Override
    public RoomResponse getRoomById(UUID roomId) {
        return service.getRoomById(roomId);
    }

    @Override
    public List<RoomResponse> getRooms() {
        return service.getRooms();
    }

    @Override
    public RoomResponse updateRoom(UUID roomId, RoomRequest request) {
        return service.updateRoomById(roomId, request);
    }

    @Override
    public void deleteRoomById(UUID roomId) {
        service.deleteRoomById(roomId);
    }
}
