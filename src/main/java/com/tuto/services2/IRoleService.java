package com.tuto.services2;

import java.util.List;

import com.tuto.entities2.Role;

public interface IRoleService {
	public Role createRole(Role role);
	public List<Role> getListAllRoles();
	public Role findRoleById(Long id);

}
