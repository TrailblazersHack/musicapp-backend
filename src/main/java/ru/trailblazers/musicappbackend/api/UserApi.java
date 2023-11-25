package ru.trailblazers.musicappbackend.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.trailblazers.musicappbackend.dto.request.UserRequest;
import ru.trailblazers.musicappbackend.dto.response.UserResponse;

import java.util.List;
import java.util.UUID;

@Api(tags = "Users | Пользователи", value = "Пользователь")
@RequestMapping("/users")
public interface UserApi {
    @ApiOperation(value = "Создание пользователя", nickname = "create-user", response = UserResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пользователь создан", response = UUID.class),
            @ApiResponse(code = 400, message = "Ошибка валидации")})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UserResponse createUser(@RequestBody UserRequest request);

    @ApiOperation(value = "Получение пользователя по ID", nickname = "get-user-by-id", response = UserResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пользователь получен", response = UUID.class),
            @ApiResponse(code = 400, message = "Пользователь не найден")})
    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    UserResponse getUserById(@PathVariable UUID userId);

    @ApiOperation(value = "Получение списка пользователей", nickname = "get-all-users", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Список пользователей получен")})
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    List<UserResponse> getStudents();

    @ApiOperation(value = "Обновление пользователя", nickname = "update-user", response = UserResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пользователь обновлён"),
            @ApiResponse(code = 400, message = "Ошибка валидации")})
    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    UserResponse updateUser(@PathVariable UUID userId, UserRequest request);

    @ApiOperation(value = "Удаление пользователя", nickname = "delete-user", response = Void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Пользователь удалён"),
            @ApiResponse(code = 400, message = "Пользователь не найден")})
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    void deleteUserById(@PathVariable UUID userId);
}
