package com.tuto.services2;

import java.util.List;

import com.tuto.entities2.User;

public interface IUserService {
	public User createUser(User user);
	public List<User> getListAllUsers();
	public User findUserById(String id);
	public void addRoleToUser(String userName, String roleName);
	public User authenticate(String userName, String password);

}
