package ru.trailblazers.musicappbackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.trailblazers.musicappbackend.dto.validation.constraint.SignInConstraint;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SignInConstraint
public class SignInRequest {
    private String username;
    private String password;
}
