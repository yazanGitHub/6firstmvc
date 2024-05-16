package com.myspring.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {
	
	String message() default "{invalidAgeMessage}";
	
	int lower() default 18;
	
	int upper() default 60;
	
	// every annotation should have these two element
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
