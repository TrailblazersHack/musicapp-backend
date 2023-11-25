package ru.trailblazers.musicappbackend.dto.request;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private Integer age;
}
