package ru.trailblazers.musicappbackend.dto.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.trailblazers.musicappbackend.dto.validation.validator.TrackValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = TrackValidator.class)
@Target({TYPE})
@Retention(RUNTIME)
public @interface TrackConstraint {
    String message() default "{TrackConstraint error}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
