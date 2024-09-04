package org.example.intern.validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CapitalizedValidator.class)

@Target({ ElementType.METHOD, ElementType.FIELD })

@Retention(RetentionPolicy.RUNTIME)

public @interface CapitalizedConstraint {
    String message() default "Chữ cái đầu phải viết hoa!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
