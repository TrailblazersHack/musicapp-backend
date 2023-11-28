package ru.trailblazers.musicappbackend.dto.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.springframework.util.StringUtils;
import ru.trailblazers.musicappbackend.dto.request.UserRequest;
import ru.trailblazers.musicappbackend.dto.validation.constraint.UserConstraint;

import java.util.Objects;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.hasText;

public class UsernameValidator implements ConstraintValidator<UserConstraint, UserRequest> {
    private static final String MESSAGE_USERNAME = "Имя пользователя не может быть пустым.";

    @Override
    @SneakyThrows
    public boolean isValid(UserRequest request, ConstraintValidatorContext context) {
        boolean valid = true;
        if (isNull(request.getUsername()) || !hasText(request.getUsername())) {
            valid = false;
            buildConstraintViolationWithTemplate(context, MESSAGE_USERNAME, request.getClass().getField("username").getName());
        }
        return valid;
    }

    private void buildConstraintViolationWithTemplate(ConstraintValidatorContext context, String message, String fieldName) {
        context.buildConstraintViolationWithTemplate(message)
                .addPropertyNode(fieldName)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
    }
}
