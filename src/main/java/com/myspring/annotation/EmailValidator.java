package com.myspring.annotation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myspring.api.UserRegistrationDTO;

public class EmailValidator implements Validator {

	// return the class which this Validator applied to
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserRegistrationDTO.class.equals(clazz);
	}

	// what to do goes here
	@Override
	public void validate(Object target, Errors errors) {
		UserRegistrationDTO userRegDTO = (UserRegistrationDTO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact.email", "email.empty");
		
		// check if email is in specific domain
		if (!userRegDTO.getContact().getEmail().endsWith("mydomain.com"))
		{
			errors.rejectValue("contact.email", "email.wrongDomain");
		}

	}

}
