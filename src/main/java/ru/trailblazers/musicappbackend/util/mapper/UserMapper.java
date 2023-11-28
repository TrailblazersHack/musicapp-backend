package ru.trailblazers.musicappbackend.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.trailblazers.musicappbackend.dto.request.SignUpRequest;
import ru.trailblazers.musicappbackend.dto.request.UserRequest;
import ru.trailblazers.musicappbackend.dto.response.UserResponse;
import ru.trailblazers.musicappbackend.entity.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

//    @Mapping(target = "username", source = "username", ignore = false)
//    @Mapping(target = "age", source = "age", ignore = false)
    User toEntity(UserRequest request);

    User toEntity(SignUpRequest request);

    UserResponse toDto(User user);

    List<UserResponse> toDtoList(List<User> users);
}
