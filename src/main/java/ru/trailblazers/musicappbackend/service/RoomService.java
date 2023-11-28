package ru.trailblazers.musicappbackend.service;

import ru.trailblazers.musicappbackend.dto.request.RoomRequest;
import ru.trailblazers.musicappbackend.dto.response.RoomResponse;

import java.util.List;
import java.util.UUID;

public interface RoomService {
    RoomResponse addNewRoom(RoomRequest request);
    RoomResponse updateRoomById(UUID RoomId, RoomRequest request);
    RoomResponse getRoomById(UUID RoomId);
    void deleteRoomById(UUID RoomId);
    List<RoomResponse> getRooms();
    RoomResponse addUserToRoom(UUID roomId, UUID userId);
    RoomResponse removeUserFromRoom(UUID roomId, UUID userId);
}
