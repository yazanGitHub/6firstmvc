package com.myspring.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspring.annotation.EmailValidator;
import com.myspring.api.ContactDTO;
import com.myspring.api.Phone;
import com.myspring.api.UserRegistrationDTO;
import com.myspring.propertyEditor.myNamePropertyEditor;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {
	
	@RequestMapping("/wantregister")
	public String showRegisterationPage(@ModelAttribute("registerDTO")  UserRegistrationDTO dto)
	{
		ContactDTO contact = new ContactDTO();
		Phone      phone   = new Phone();
		phone.setCountryCode("+49");
		phone.setUserNumber("2342342");
		contact.setEmail("email.com");
		// here where the formatter.printer get called
		contact.setPhone(phone);
		
		return "user-registration-page";
	}
	
	@RequestMapping("/register")
	public String register(@Valid @ModelAttribute("registerDTO") UserRegistrationDTO dto, BindingResult result)
	{
		
		// this one way to call our validator or to call it in initBinding method
		EmailValidator emailVal = new EmailValidator();
		emailVal.validate(dto, result);
		if (result.hasErrors())
		{
			System.out.println("my page has error");
			List<ObjectError>  allError = result.getAllErrors();
			for(ObjectError error : allError)
			{
				System.out.println(error);
			}
			
			return "user-registration-page";
		}
		return "reigster-success";		
	}
	
	// this method will called before the controller because it will control the binding property
	// it will allow my to play with request properties
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		System.out.println("Hello from binder ....");
		// here we will prevent the userRegisterationDTO to bind the name property value
		// that mean the binder will exclude the name property from the binding process
		binder.setDisallowedFields("userName");
		// in this case if the user enter the whitespace the binder will trim it to not trick the system
		StringTrimmerEditor stringEditor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, "name", stringEditor);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		CustomDateEditor dateEditor= new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, "date", dateEditor);
		
		
		// use our private binding class
		myNamePropertyEditor myNameEditor = new myNamePropertyEditor();
		binder.registerCustomEditor(String.class,"name", myNameEditor);
		
		// register the email validator
		binder.addValidators(new EmailValidator());
				
	}
		
}
