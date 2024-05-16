package com.myspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myspring.api.UserDTO;

import jakarta.validation.Valid;

@Controller
@Validated
public class MainController {

	@RequestMapping("/ping")
	public void ping() {
		System.out.println("you are in MainController");
	}

	@RequestMapping("/")
	public String showHomePage() {
		System.out.println("Hello From MainController");
		return "main-page";
	}

	@RequestMapping("/process-homepage")
	public String processHomePage(@RequestParam(name = "userName") String userName,
			@RequestParam(name = "crushName") String crushName, Model model) {

		System.out.println("user Name is " + userName);
		System.out.println("crush Name is " + crushName);
		model.addAttribute("userName", userName);
		model.addAttribute("crushName", crushName);

		return "result-page";

	}

	// or we can write it in this way

//	@RequestMapping("/process-homepage/usingObject")
//	public String processHomePageUsingObject(UserDTO userDTO, Model model)
//	{
//		// here the spring framework will create the userDTO and use the setter to bind what it find 
//		// in the request parameter with the object properties
//		
//		System.out.println("user Name is " + userDTO.getUserName());
//		System.out.println("crush Name is " + userDTO.getCrushName());
//		model.addAttribute("userInfo",userDTO);
//	
//		return "result-page";
//		
//	}

//	@RequestMapping("/DefaultValue")
//	public String showHomePageDefaultValue(Model model)
//	{
//		UserDTO userDTO = new UserDTO();
//		model.addAttribute("userInfo", userDTO);
//		return "main-page";
//	}
	@RequestMapping("/DefaultValue")
	public String showHomePageDefaultValue(@ModelAttribute("userInfo") UserDTO unserDTO) {
		return "main-page";
	}

	// and the proccess method should be then
	@RequestMapping("/process-homepage/usingObject")
	public String processHomePage(@Valid @ModelAttribute("userInfo") UserDTO userDTO, BindingResult bindResult) {
		
		if (bindResult.hasErrors()) {
			System.out.println("my form has errors....");
		}
		return "result-page";
	}

}
