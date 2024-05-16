package com.myspring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myspring.api.ContactDTO;
import com.myspring.api.Phone;
import com.myspring.api.UserRegistrationDTO;

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
		System.out.println(dto.getCountry());
		System.out.println(dto.getGender());
		System.out.println(dto.getName());
		System.out.println(dto.getPassword());
		System.out.println(dto.getUserName());
		System.out.println(dto.getAge());
		System.out.println(dto.getContact().getEmail());
		// here where the formetter.parse get called
		System.out.println(dto.getContact().getPhone());
		
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
		
}
