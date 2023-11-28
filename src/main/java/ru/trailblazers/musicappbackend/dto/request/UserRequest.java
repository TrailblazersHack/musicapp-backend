package ru.trailblazers.musicappbackend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.trailblazers.musicappbackend.dto.validation.constraint.UserConstraint;

@Data
@AllArgsConstructor
@NoArgsConstructor
@UserConstraint
public class UserRequest {

    private String username;
    private Integer age;
}
