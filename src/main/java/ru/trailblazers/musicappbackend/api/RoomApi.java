package ru.trailblazers.musicappbackend.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.trailblazers.musicappbackend.dto.request.CreateRoomRequest;
import ru.trailblazers.musicappbackend.dto.request.RoomRequest;
import ru.trailblazers.musicappbackend.dto.response.RoomResponse;

import java.util.List;
import java.util.UUID;

@Tag(name = "Rooms | Комнаты", description = "Комната")
@RequestMapping("/rooms")
public interface RoomApi {

    @Operation(summary = "Создание комнаты", operationId = "create-room")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Комната создана"),
            @ApiResponse(responseCode = "400", description = "Ошибка валидации")})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    RoomResponse createRoom(@RequestBody CreateRoomRequest request);

    @Operation(summary = "Получение комнаты по ID", operationId = "get-room-by-id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Комната получена"),
            @ApiResponse(responseCode = "400", description = "Комната не найдена")})
    @GetMapping("/{roomId}")
    @ResponseStatus(HttpStatus.OK)
    RoomResponse getRoomById(@PathVariable UUID roomId);

    @Operation(summary = "Получение списка комнат", operationId = "get-all-rooms")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список комнат получен")})
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    List<RoomResponse> getRooms();

    @Operation(summary = "Обновление комнаты", operationId = "update-room")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Комната обновлена"),
            @ApiResponse(responseCode = "400", description = "Ошибка валидации")})
    @PutMapping("/{roomId}")
    @ResponseStatus(HttpStatus.OK)
    RoomResponse updateRoom(@PathVariable UUID roomId, RoomRequest request);

    @Operation(summary = "Удаление комнаты", operationId = "delete-room")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Комната удалена"),
            @ApiResponse(responseCode = "400", description = "Комната не найдена")})
    @DeleteMapping("/{roomId}")
    @ResponseStatus(HttpStatus.OK)
    void deleteRoomById(@PathVariable UUID roomId);

    @Operation(summary = "Добавление пользователя в комнату", operationId = "add-user-to-room")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь добавлен в комнату"),
            @ApiResponse(responseCode = "400", description = "Ошибка валидации.")})
    @PutMapping("/{roomId}/addUser")
    @ResponseStatus(HttpStatus.OK)
    RoomResponse addUserToRoom(@PathVariable UUID roomId, UUID userId);

    @Operation(summary = "Удаление пользователя из комнаты", operationId = "remove-user-from-room")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь удалён из комнаты"),
            @ApiResponse(responseCode = "400", description = "Ошибка валидации.")})
    @PutMapping("/{roomId}/removeUser")
    @ResponseStatus(HttpStatus.OK)
    RoomResponse removeUserFromRoom(@PathVariable UUID roomId, UUID userId);
}
