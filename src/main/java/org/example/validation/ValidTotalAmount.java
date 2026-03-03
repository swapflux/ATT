package org.example.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TotalAmountValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidTotalAmount {

    String message() default "Total amount must be equal to quantity × price";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}