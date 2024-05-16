package com.myspring.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer>{

	private int lower;
	private int upper;
	
	// t do some work  post construct
	// and it is optional to overriding it
	@Override
	public void initialize(Age constraintAnnotation /*this is the value that the dev will put above the field*/) {
		
		// overriding the value given by the developer over the value that exist inside the Age annotation file 
		this.lower = constraintAnnotation.lower();
		this.upper = constraintAnnotation.upper();
	
	}
	
	@Override
	public boolean isValid(Integer value/*the end user given value*/, ConstraintValidatorContext context) {
		if (value < lower || value > upper)
		{
			return false;
		}
		return true;
	}
	
}
