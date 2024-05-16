package com.myspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MyController {
	
	@RequestMapping("test")
	public String sayHallo()
	{
		System.out.println("Hello from MyController");
		return "Hellofromjsp";
	}
	
	
	

}
