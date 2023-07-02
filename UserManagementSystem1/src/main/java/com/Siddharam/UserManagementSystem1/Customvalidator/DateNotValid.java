package com.Siddharam.UserManagementSystem1.Customvalidator;

import com.Siddharam.UserManagementSystem1.Customvalidationimpl.DateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface DateNotValid {


    String message()default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
