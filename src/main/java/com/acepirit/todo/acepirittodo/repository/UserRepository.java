package com.acepirit.todo.acepirittodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acepirit.todo.acepirittodo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUserName(String username);
	
	
}
