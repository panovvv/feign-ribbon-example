package com.shortn0tes.userservice.controller;

import com.shortn0tes.userservice.model.User;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 1/11/2018.
 */
@Controller
public class UserController {

	final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	@ResponseBody
	User createUser(User user) {
		user.setId(11L);
		LOGGER.info(String.format("Created user with id %d in this instance", user.getId()));
		return user;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	@ResponseBody
	List<User> getUsers() {
		LOGGER.info("Got all users from this instance");
		return LongStream.rangeClosed(1, 10)
			.mapToObj(userId -> {
				User user = new User();
				user.setId(userId);
				return user.randomize();
			}).collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
	@ResponseBody
	User getUser(@PathVariable("userId") Long userId) {
		LOGGER.info("Got one user from this instance");
		User user = new User();
		user.setId(userId);
		return user.randomize();
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}")
	@ResponseBody
	User updateUser(@PathVariable("userId") Long userId, User user) {
		LOGGER.info(String.format("Updated user with id %d in this instance", userId));
		return user;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
	ResponseEntity deleteUser(@PathVariable("userId") Long userId) {
		LOGGER.info(String.format("Deleted user with id %d from this instance", userId));
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
