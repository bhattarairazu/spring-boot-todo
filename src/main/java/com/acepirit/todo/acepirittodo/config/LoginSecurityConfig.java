package com.acepirit.todo.acepirittodo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.acepirit.todo.acepirittodo.service.UserService;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomSuccessAuthenticationHandler customsuccesshandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest().authenticated()
//			.antMatchers("/showLoginPage").hasRole("EMPLOYEE")
//			.antMatchers("/board/listboards").hasRole("EMPLOYEE")
//			.antMatchers("/board/listtask/**").hasRole("EMPLOYEE")
//			.antMatchers("/task/taskdetails/**").hasRole("EMPLOYEE")
//			.antMatchers("/task/ChangeSubtaskStatus/**").hasRole("EMPLOYEE")
//			.antMatchers("/task/showAddComment/**").hasRole("EMPLOYEE")
//			.antMatchers("/task/saveComment/**").hasRole("EMPLOYEE")
//
//			.antMatchers("/register/showRegistrationForm").hasRole("EMPLOYEE")
//			.antMatchers("/task/processRegistrationForm").hasRole("EMPLOYEE")
//			
//			.antMatchers("/showLoginPage").hasRole("ADMIN")
//			.antMatchers("/board/listboards").hasRole("ADMIN")
//			.antMatchers("/task/**").hasRole("ADMIN")
//			.antMatchers("/register/*").hasRole("ADMIN")
			
		.and()
			.formLogin()
			.loginPage("/showLoginPage")
			.loginProcessingUrl("/authenticationProcessing")
			.successHandler(customsuccesshandler)
			.permitAll()
			.and().logout().permitAll();
	}
	
	//beans
			//bcrypt bean definition
			@Bean
			public BCryptPasswordEncoder passwordEncoder() {
				return new BCryptPasswordEncoder();
			}

			//authenticationProvider bean definition
			@Bean
			public DaoAuthenticationProvider authenticationProvider() {
				DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
				auth.setUserDetailsService(userService); //set the custom user details service
				auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
				return auth;
			}
	
	

}
