package com.acepirit.todo.acepirittodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acepirit.todo.acepirittodo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	public Role findRoleByName(String theRoleName);

}
