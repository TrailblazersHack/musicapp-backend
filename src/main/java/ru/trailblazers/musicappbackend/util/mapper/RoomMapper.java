package ru.trailblazers.musicappbackend.util.mapper;

import org.mapstruct.Mapper;
import ru.trailblazers.musicappbackend.dto.request.RoomRequest;
import ru.trailblazers.musicappbackend.dto.response.RoomResponse;
import ru.trailblazers.musicappbackend.entity.Room;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    Room toEntity(RoomRequest request);

    RoomResponse toDto(Room Room);

    List<RoomResponse> toDtoList(List<Room> Rooms);
}

