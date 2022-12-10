package com.tuto.repositories2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuto.entities2.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	public Role findByName(String name);

}
