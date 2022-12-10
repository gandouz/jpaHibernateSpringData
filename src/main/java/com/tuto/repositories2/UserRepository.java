package com.tuto.repositories2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuto.entities2.User;

public interface UserRepository extends JpaRepository<User, String>{
	public User findByName(String name);

}
