package ru.trailblazers.musicappbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.trailblazers.musicappbackend.dto.request.RoomRequest;
import ru.trailblazers.musicappbackend.dto.response.RoomResponse;
import ru.trailblazers.musicappbackend.entity.User;
import ru.trailblazers.musicappbackend.entity.Room;
import ru.trailblazers.musicappbackend.entity.enums.Status;
import ru.trailblazers.musicappbackend.exception.RoomNotFoundException;
import ru.trailblazers.musicappbackend.exception.UserNotFoundException;
import ru.trailblazers.musicappbackend.repository.RoomRepository;
import ru.trailblazers.musicappbackend.repository.UserRepository;
import ru.trailblazers.musicappbackend.service.RoomService;
import ru.trailblazers.musicappbackend.util.mapper.RoomMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final UserRepository userRepository;
    private final RoomRepository repository;
    private final RoomMapper mapper;

    @Override
    public RoomResponse addNewRoom(RoomRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new UserNotFoundException(request.getUserId()));
        Room room = Room.builder()
                .id(UUID.randomUUID())
                .title(request.getTitle())
                .host(user)
                .status(Status.CONFIRMED)
                .users(new ArrayList<>())
                .build();
        room.getUsers().add(user);
        repository.save(room);
        return mapper.toDto(room);
    }

    @Override
    public RoomResponse updateRoomById(UUID roomId, RoomRequest request) {
        Room Room = getByIdOrThrow(roomId);
        Room.setTitle(request.getTitle());
        repository.save(Room);
        return mapper.toDto(Room);
    }

    @Override
    @Transactional
    public RoomResponse getRoomById(UUID roomId) {
        Room Room = getByIdOrThrow(roomId);
        return mapper.toDto(Room);
    }

    @Override
    public void deleteRoomById(UUID roomId) {
        Room Room = getByIdOrThrow(roomId);
        Room.setStatus(Status.DELETED);
        repository.save(Room);
    }

    @Override
    public List<RoomResponse> getRooms() {
        List<Room> Rooms = repository.findAll();
        return mapper.toDtoList(Rooms);
    }

    @Override
    public RoomResponse addUserToRoom(UUID userId, UUID roomId) {
        User user = getUserByIdOrThrow(userId);
        Room room = getByIdOrThrow(roomId);
        room.getUsers().add(user);
        repository.save(room);
        return mapper.toDto(room);
    }

    @Override
    public RoomResponse removeUserFromRoom(UUID userId, UUID roomId) {
        User user = getUserByIdOrThrow(userId);
        Room room = getByIdOrThrow(roomId);
        room.getUsers().remove(user);
        repository.save(room);
        return mapper.toDto(room);
    }

    private Room getByIdOrThrow(UUID roomId) {
        Optional<Room> room = repository.findById(roomId);
        if (room.isPresent()) {
            Room getRoom = room.get();
            if (getRoom.getStatus().equals(Status.DELETED)) {
                throw new RoomNotFoundException(roomId);
            }
            return getRoom;
        } else {
            throw new RoomNotFoundException(roomId);
        }
    }

    private User getUserByIdOrThrow(UUID userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException(userId);
        }
    }
}
