package com.tuto.services2.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.tuto.entities2.Role;
import com.tuto.entities2.User;
import com.tuto.repositories2.RoleRepository;
import com.tuto.repositories2.UserRepository;
import com.tuto.services2.IUserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService implements IUserService, ApplicationContextAware{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	private String applicationId;

	@Override
	public User createUser(User user) {
		user.setId(UUID.randomUUID().toString());
		// il faut hasher le password ici
		//
		return userRepository.save(user);
	}

	@Override
	public List<User> getListAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUserById(String id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {
		User user = userRepository.findByName(userName);
		Role role = roleRepository.findByName(roleName);
		
		/*
		 * it depends from the place of mappedBy option
		 */
		user.getRoles().add(role);
		//role.getUsers().add(user);
		
		// Le save est optionnel car la classe est Transactionnal => commit automatique
		//userRepository.save(user);
	}

	@Override
	public User authenticate(String userName, String password) {
		User user = userRepository.findByName(userName);
		if (user == null) throw new RuntimeException("Bad credentials");
		if (user.getPassword().equals(password)) {
			return user;
		}
		throw new RuntimeException("Bad credentials");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		//applicationId = applicationContext.getId();
		applicationId = applicationContext.toString();
    }

    public String getApplicationId() {

        return applicationId;
    }

}
