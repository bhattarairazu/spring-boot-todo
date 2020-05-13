package com.acepirit.todo.acepirittodo.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CrmUser {
	@NotNull(message="Username cannotbe null")
	@Size(min=1,message="Username should be greater than 1")
	private String userName;
	
	@NotNull(message="Password cannotbe null")
	@Size(min=1,message="Password should be greater than 1")
	private String password;
	
	@NotNull(message="Confirm cannotbe null")
	@Size(min=1,message="confirm should be greater than 1")
	private String matchingPassword;
	
	@NotNull(message="firstName cannotbe null")
	@Size(min=1,message="firstName should be greater than 1")
	private String firstName;
	
	
	@NotNull(message="lastName cannotbe null")
	@Size(min=1,message="lastName should be greater than 1")
	private String lastName;
	
	@NotNull(message="email cannotbe null")
	@Size(min=1,message="email should be greater than 1")
	private String email;
	
	public CrmUser() {}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
	
}
