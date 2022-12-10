package com.tuto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tuto.entities2.Role;
import com.tuto.entities2.User;
import com.tuto.services2.IRoleService;
import com.tuto.services2.IUserService;

@RestController
public class UsersRolesController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@GetMapping("/users")
	public List<User> listAllUsers(){
		return userService.getListAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable String id){
		return userService.findUserById(id);
	}
	
	@GetMapping("/roles")
	public List<Role> listAllRoles(){
		return roleService.getListAllRoles();
	}
	
	@GetMapping("/roles/{id}")
	public Role retrieveRole(@PathVariable Long id){
		return roleService.findRoleById(id);
	}
}
