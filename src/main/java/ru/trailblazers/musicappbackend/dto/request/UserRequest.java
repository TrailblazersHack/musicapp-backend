package ru.trailblazers.musicappbackend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "request")
public class UserRequest {

    @SchemaProperty
    private String username;
    @SchemaProperty
    private Integer age;
}
