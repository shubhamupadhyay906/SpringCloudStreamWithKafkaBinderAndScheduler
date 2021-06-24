package com.mindtree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.model.ConsumerUser;
import com.mindtree.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	


	@StreamListener("input")
    public void consumeMessage(ConsumerUser user) {
        log.info("Consume payload : " + user);
        userService.addAllUser(user);
    }
	

}
