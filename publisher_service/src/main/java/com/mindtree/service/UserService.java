package com.mindtree.service;

import java.util.List;

import com.mindtree.model.User;

public interface UserService {

	
	public List<User> getUsers();

	public void saveData(User user);

}
