package com.mindtree.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mindtree.model.ConsumerUser;

import com.mindtree.repository.UserRepository;
import com.mindtree.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void addAllUser(ConsumerUser user) {
		userRepository.save(user);
		
	}
	
	

}
