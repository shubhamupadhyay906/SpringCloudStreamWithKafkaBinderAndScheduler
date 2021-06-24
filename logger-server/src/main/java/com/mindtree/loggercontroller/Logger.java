package com.mindtree.loggercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableBinding(Source.class)
public class Logger {
	
	@Autowired
	private MessageChannel output;

	@StreamListener("input")
	public void getUser(User user) {
		log.info("user data :" + user);
		user.setStatus("Done");
		output.send(MessageBuilder.withPayload(user).build());

	}

}
