package ru.trailblazers.musicappbackend.dto.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;
import org.springframework.util.StringUtils;
import ru.trailblazers.musicappbackend.dto.request.SignInRequest;
import ru.trailblazers.musicappbackend.dto.validation.constraint.SignInConstraint;

import java.util.Objects;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.hasText;

public class SignInValidator implements ConstraintValidator<SignInConstraint, SignInRequest> {

    private static final String MESSAGE_USERNAME = "Имя пользователя не может быть пустым.";
    private static final String MESSAGE_PASSWORD = "Пароль не может быть пустым.";

    @Override
    @SneakyThrows
    public boolean isValid(SignInRequest request, ConstraintValidatorContext context) {
        boolean valid = true;
        if (isNull(request.getUsername()) || !hasText(request.getUsername())) {
            valid = false;
            buildConstraintViolationWithTemplate(context, MESSAGE_USERNAME, "username");
        }
        if (isNull(request.getPassword()) || !hasText(request.getPassword())) {
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
