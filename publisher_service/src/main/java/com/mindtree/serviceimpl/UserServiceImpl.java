package com.mindtree.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mindtree.model.User;
import com.mindtree.repository.UserRepository;
import com.mindtree.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	// add object in db for every 5 sec
//	@Override
//	@Scheduled(fixedRate = 5000)
//	public void addUser() {
//		User user = new User();
//		userRepository.save(user);
//		log.info("add service call in "+new Date().toString());
//	}

	@Override
	public List<User> getUsers() {
		List<User> user = userRepository.findAll();
		return user;
	}

	@Override
	public void saveData(User user) {
		userRepository.save(user);
	}

}
