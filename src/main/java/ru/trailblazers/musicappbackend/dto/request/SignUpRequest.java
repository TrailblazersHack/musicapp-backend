package ru.trailblazers.musicappbackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.trailblazers.musicappbackend.dto.validation.constraint.SignUpConstraint;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SignUpConstraint
public class SignUpRequest {
    private String username;
    private Integer age;
    private String email;
    private String password;
}