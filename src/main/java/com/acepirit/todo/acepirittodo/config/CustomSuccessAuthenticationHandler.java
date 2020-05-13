package com.acepirit.todo.acepirittodo.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.acepirit.todo.acepirittodo.entity.User;
import com.acepirit.todo.acepirittodo.service.UserService;

@Component
public class CustomSuccessAuthenticationHandler implements AuthenticationSuccessHandler {

	@Autowired
	public UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String name = authentication.getName();
		
		User user = userService.findByUserName(name);
		
		HttpSession sessions = request.getSession();
		sessions.setAttribute("user", user);
		
		response.sendRedirect(request.getContextPath()+"/board/listboards");
		
		

	}

}
