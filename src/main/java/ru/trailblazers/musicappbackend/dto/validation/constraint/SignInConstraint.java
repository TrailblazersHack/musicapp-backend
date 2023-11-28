package ru.trailblazers.musicappbackend.dto.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.trailblazers.musicappbackend.dto.validation.validator.SignInValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = SignInValidator.class)
@Target({TYPE})
@Retention(RUNTIME)
public @interface SignInConstraint {
    String message() default "{SignInConstraint error}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
