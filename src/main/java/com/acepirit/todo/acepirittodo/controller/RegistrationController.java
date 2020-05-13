package com.acepirit.todo.acepirittodo.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acepirit.todo.acepirittodo.entity.User;
import com.acepirit.todo.acepirittodo.service.UserService;
import com.acepirit.todo.acepirittodo.user.CrmUser;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	@Autowired
	private UserService userService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model theModel) {
		
		theModel.addAttribute("crmUser",new CrmUser());
		return "login/registration-form";
	}
	
	@PostMapping("/processRegistrationForm")
	public String procesForm(@Valid @ModelAttribute("crmUser") CrmUser crmUser,BindingResult theBindingResult,Model theModel) {
		
		String name = crmUser.getUserName();
		
		logger.info("name is "+name);
		
		if(theBindingResult.hasErrors()) {
			return "login/registration-form";
		}
		User user = userService.findByUserName(name);
		if(user!=null) {
			theModel.addAttribute("crmUser",new CrmUser());
			theModel.addAttribute("registrationError","Usernme Already Exist");
			return "login/registration-form";
		}
		
		logger.info("crm user is "+crmUser);
		userService.save(crmUser);
		
		return "login/registration-confirmation";
		
		
	}
	
}
