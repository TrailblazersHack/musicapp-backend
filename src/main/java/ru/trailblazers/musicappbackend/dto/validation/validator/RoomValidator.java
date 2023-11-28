package ru.trailblazers.musicappbackend.dto.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;
import ru.trailblazers.musicappbackend.dto.request.RoomRequest;
import ru.trailblazers.musicappbackend.dto.validation.constraint.RoomConstraint;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.hasText;

public class RoomValidator implements ConstraintValidator<RoomConstraint, RoomRequest> {

    private static final String MESSAGE_TITLE = "Название комнаты не может быть пустым.";
    private static final String MESSAGE_USER_ID = "ID пользователя не должно быть пустым.";

    @Override
    @SneakyThrows
    public boolean isValid(RoomRequest request, ConstraintValidatorContext context) {
        boolean valid = true;
        if (isNull(request.getTitle()) || !hasText(request.getTitle())) {
            valid = false;
            buildConstraintViolationWithTemplate(context, MESSAGE_TITLE, "title");
        }
        if (isNull(request.getUserId()) || !hasText(request.getUserId().toString())) {
            valid = false;
            buildConstraintViolationWithTemplate(context, MESSAGE_USER_ID, "userId");
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
