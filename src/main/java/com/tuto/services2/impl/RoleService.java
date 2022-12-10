package com.tuto.services2.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuto.entities2.Role;
import com.tuto.repositories2.RoleRepository;
import com.tuto.services2.IRoleService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoleService implements IRoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> getListAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role findRoleById(Long id) {
		return roleRepository.findById(id).get();
	}

}
