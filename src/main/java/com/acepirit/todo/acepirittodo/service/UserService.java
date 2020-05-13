package com.acepirit.todo.acepirittodo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.acepirit.todo.acepirittodo.entity.User;
import com.acepirit.todo.acepirittodo.user.CrmUser;

public interface UserService extends UserDetailsService {
	
	public User findByUserName(String username);
	
	public void save(CrmUser crmuser);
	
	

}
