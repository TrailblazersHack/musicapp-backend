package ru.trailblazers.musicappbackend.util.mapper;

import org.mapstruct.Mapper;
import ru.trailblazers.musicappbackend.dto.request.TrackRequest;
import ru.trailblazers.musicappbackend.dto.response.TrackResponse;
import ru.trailblazers.musicappbackend.entity.Track;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrackMapper {

    Track toEntity(TrackRequest request);
    TrackResponse toDto(Track track);
    List<TrackResponse> toListDto(List<Track> tracks);
}
