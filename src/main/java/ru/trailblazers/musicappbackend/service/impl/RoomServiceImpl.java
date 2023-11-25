package ru.trailblazers.musicappbackend.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.trailblazers.musicappbackend.dto.request.RoomRequest;
import ru.trailblazers.musicappbackend.dto.request.RoomRequest;
import ru.trailblazers.musicappbackend.dto.response.RoomResponse;
import ru.trailblazers.musicappbackend.dto.response.RoomResponse;
import ru.trailblazers.musicappbackend.entity.Room;
import ru.trailblazers.musicappbackend.entity.enums.Status;
import ru.trailblazers.musicappbackend.exception.RoomNotFoundException;
import ru.trailblazers.musicappbackend.repository.RoomRepository;
import ru.trailblazers.musicappbackend.service.RoomService;
import ru.trailblazers.musicappbackend.util.mapper.RoomMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository repository;
    private final RoomMapper mapper;

    @Override
    @Transactional
    public RoomResponse addNewRoom(RoomRequest request) {
        Room Room = mapper.toEntity(request);
        Room.setId(UUID.randomUUID());
        Room.setStatus(Status.CONFIRMED);
        repository.save(Room);
        return mapper.toDto(Room);
    }

    @Override
    public RoomResponse updateRoomById(UUID RoomId, RoomRequest request) {
        Room Room = getByIdOrThrow(RoomId);
        Room.setTitle(request.getTitle());
        Room.setLimitUsers(request.getLimitUsers());
        Room.setPrivacy(request.getPrivacy());
        repository.save(Room);
        return mapper.toDto(Room);
    }

    @Override
    public RoomResponse getRoomById(UUID RoomId) {
        Room Room = getByIdOrThrow(RoomId);
        return mapper.toDto(Room);
    }

    @Override
    public void deleteRoomById(UUID RoomId) {
        Room Room = getByIdOrThrow(RoomId);
        Room.setStatus(Status.DELETED);
        repository.save(Room);
    }

    @Override
    public List<RoomResponse> getRooms() {
        List<Room> Rooms = repository.findAll();
        return mapper.toDtoList(Rooms);
    }

    private Room getByIdOrThrow(UUID RoomId) {
        Optional<Room> Room = repository.findById(RoomId);
        if (Room.isPresent()) {
            Room getRoom = Room.get();
            if (getRoom.getStatus().equals(Status.DELETED)) {
                throw new RoomNotFoundException(RoomId);
            }
            return getRoom;
        } else {
            throw new RoomNotFoundException(RoomId);
        }
    }
}
