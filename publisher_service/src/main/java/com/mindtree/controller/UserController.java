package com.mindtree.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.model.User;
import com.mindtree.repository.UserRepository;
import com.mindtree.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private MessageChannel output;

	@Scheduled(cron = "0/15 * * * * *")
	public void getUsers() {
		List<User> users = userService.getUsers();
		for (User user : users) {
			if (user.getStatus().equals("unqueue")) {
				user.setStatus("queue");
				output.send(MessageBuilder.withPayload(user).build());
				userService.saveData(user);
			}
		}

	}

}
