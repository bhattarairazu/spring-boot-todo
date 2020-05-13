package com.acepirit.todo.acepirittodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	
	@GetMapping("/showLoginPage")
	public String showLoginForm() {
		return "login/fancy-login";
	}
	
	
	
	
	

}
