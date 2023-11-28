package ru.trailblazers.musicappbackend.dto.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;
import org.springframework.util.StringUtils;
import ru.trailblazers.musicappbackend.dto.request.TrackRequest;
import ru.trailblazers.musicappbackend.dto.validation.constraint.TrackConstraint;

import java.util.Objects;

public class TrackValidator implements ConstraintValidator<TrackConstraint, TrackRequest> {

    private static final String MESSAGE_TITLE = "Название трека не может быть пустым.";

    @Override
    @SneakyThrows
    public boolean isValid(TrackRequest request, ConstraintValidatorContext context) {
        boolean valid = true;
        if (Objects.isNull(request.getTitle()) || !StringUtils.hasText(request.getTitle())) {
            valid = false;
            buildConstraintViolationWithTemplate(context, MESSAGE_TITLE, "title");
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
