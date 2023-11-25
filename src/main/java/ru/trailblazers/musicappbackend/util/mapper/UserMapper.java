package ru.trailblazers.musicappbackend.util.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.trailblazers.musicappbackend.dto.request.UserRequest;
import ru.trailblazers.musicappbackend.dto.response.UserResponse;
import ru.trailblazers.musicappbackend.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRequest request);

    UserResponse toDto(User user);

    List<UserResponse> toDtoList(List<User> users);
}
