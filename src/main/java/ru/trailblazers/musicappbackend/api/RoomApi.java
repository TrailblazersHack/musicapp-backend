package ru.trailblazers.musicappbackend.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.trailblazers.musicappbackend.dto.request.RoomRequest;
import ru.trailblazers.musicappbackend.dto.request.UserRequest;
import ru.trailblazers.musicappbackend.dto.response.RoomResponse;
import ru.trailblazers.musicappbackend.dto.response.UserResponse;

import java.util.List;
import java.util.UUID;

@Api(tags = "Rooms | Комнаты", value = "Комната")
@RequestMapping("/rooms")
public interface RoomApi {

    @ApiOperation(value = "Создание комнаты", nickname = "create-room", response = RoomResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Комната создана", response = UUID.class),
            @ApiResponse(code = 400, message = "Ошибка валидации")})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    RoomResponse createRoom(@RequestBody RoomRequest request);

    @ApiOperation(value = "Получение комнаты по ID", nickname = "get-room-by-id", response = RoomResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Комната получена", response = UUID.class),
            @ApiResponse(code = 400, message = "Комната не найдена")})
    @GetMapping("/{roomId}")
    @ResponseStatus(HttpStatus.OK)
    RoomResponse getRoomById(@PathVariable UUID roomId);

    @ApiOperation(value = "Получение списка комнат", nickname = "get-all-rooms", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Список комнат получен")})
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    List<RoomResponse> getRooms();

    @ApiOperation(value = "Обновление комнаты", nickname = "update-room", response = RoomResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Комната обновлена"),
            @ApiResponse(code = 400, message = "Ошибка валидации")})
    @PutMapping("/{roomId}")
    @ResponseStatus(HttpStatus.OK)
    RoomResponse updateRoom(@PathVariable UUID roomId, RoomRequest request);

    @ApiOperation(value = "Удаление комнаты", nickname = "delete-room", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Комната удалена"),
            @ApiResponse(code = 400, message = "Комната не найдена")})
    @DeleteMapping("/{roomId}")
    @ResponseStatus(HttpStatus.OK)
    void deleteRoomById(@PathVariable UUID roomId);
}
