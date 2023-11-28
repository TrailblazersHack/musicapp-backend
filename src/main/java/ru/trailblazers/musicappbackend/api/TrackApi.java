package ru.trailblazers.musicappbackend.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.trailblazers.musicappbackend.dto.request.TrackRequest;
import ru.trailblazers.musicappbackend.dto.response.TrackResponse;

import java.util.List;
import java.util.UUID;

@Tag(name = "Tracks | Треки", description = "Трек")
@RequestMapping("/tracks")
public interface TrackApi {
    @Operation(summary = "Создание Трека", operationId = "create-track")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Трек создан"),
            @ApiResponse(responseCode = "400", description = "Ошибка валидации")})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    TrackResponse createTrack(@Valid @RequestBody TrackRequest request);

    @Operation(summary = "Получение Трека по ID", operationId = "get-track-by-id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Трек получен"),
            @ApiResponse(responseCode = "400", description = "Трек не найден")})
    @GetMapping("/{trackId}")
    @ResponseStatus(HttpStatus.OK)
    TrackResponse getTrackById(@PathVariable UUID trackId);

    @Operation(summary = "Получение списка треков", operationId = "get-all-tracks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список треков получен")})
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    List<TrackResponse> getTracks();

    @Operation(summary = "Обновление Трека", operationId = "update-track")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Трек обновлён"),
            @ApiResponse(responseCode = "400", description = "Ошибка валидации")})
    @PutMapping("/{trackId}")
    @ResponseStatus(HttpStatus.OK)
    TrackResponse updateTrack(@PathVariable UUID trackId, TrackRequest request);

    @Operation(summary = "Удаление Трека", operationId = "delete-track")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Трек удалён"),
            @ApiResponse(responseCode = "400", description = "Трек не найден", useReturnTypeSchema = true)})
    @DeleteMapping("/{trackId}")
    @ResponseStatus(HttpStatus.OK)
    void deleteTrackById(@PathVariable UUID trackId);
}
