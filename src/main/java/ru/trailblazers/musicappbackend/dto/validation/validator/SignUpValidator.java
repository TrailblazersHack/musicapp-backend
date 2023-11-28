package ru.trailblazers.musicappbackend.dto.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;
import org.springframework.util.StringUtils;
import ru.trailblazers.musicappbackend.dto.request.SignUpRequest;
import ru.trailblazers.musicappbackend.dto.validation.constraint.SignUpConstraint;

import java.util.Objects;

public class SignUpValidator implements ConstraintValidator<SignUpConstraint, SignUpRequest> {
    private static final String MESSAGE_USERNAME = "Имя пользователя не может быть пустым.";
    private static final String MESSAGE_AGE = "Возраст пользователя не может быть пустым или <= 0.";
    private static final String MESSAGE_EMAIL = "Почта пользователя не может быть пустой.";
    private static final String MESSAGE_PASSWORD = "Пароль не может быть пустым.";

    @Override
    @SneakyThrows
    public boolean isValid(SignUpRequest request, ConstraintValidatorContext context) {
        boolean valid = true;
        if (Objects.isNull(request.getUsername()) || !StringUtils.hasText(request.getUsername())) {
            valid = false;
            buildConstraintViolationWithTemplate(context, MESSAGE_USERNAME, "username");
        }
        if (Objects.isNull(request.getAge()) || request.getAge() <= 0) {
            valid = false;
            buildConstraintViolationWithTemplate(context, MESSAGE_AGE, "age");
        }
        if (Objects.isNull(request.getEmail()) || !StringUtils.hasText(request.getEmail())) {
            valid = false;
            buildConstraintViolationWithTemplate(context, MESSAGE_EMAIL, "email");
        }
        if (Objects.isNull(request.getPassword()) || !StringUtils.hasText(request.getPassword())) {
            valid = false;
            buildConstraintViolationWithTemplate(context, MESSAGE_PASSWORD, "password");
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
