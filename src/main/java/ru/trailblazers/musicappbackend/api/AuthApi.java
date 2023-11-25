package ru.trailblazers.musicappbackend.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.trailblazers.musicappbackend.dto.request.SignUpRequest;
import ru.trailblazers.musicappbackend.dto.response.JwtAuthResponse;

@Tag(name = "Authentication | Аутентификация", description = "Аутентификация")
@RequestMapping("/auth")
public interface AuthApi {

    @Operation(summary = "Создание пользователя", operationId = "create-user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь создан"),
            @ApiResponse(responseCode = "400", description = "Ошибка валидации")})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    JwtAuthResponse signUp(@RequestBody SignUpRequest request);

}
