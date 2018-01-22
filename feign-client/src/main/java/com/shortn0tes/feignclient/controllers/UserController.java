package com.shortn0tes.feignclient.controllers;

import com.netflix.config.ConfigurationManager;
import com.shortn0tes.feignclient.feign.UserClient;
import com.shortn0tes.feignclient.model.User;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 1/15/2018.
 */
@Controller
public class UserController {

	@Autowired
	UserClient userClient;

	@PostConstruct
	public void init() throws IOException {
		ConfigurationManager.loadPropertiesFromResources("ribbon-client.properties");
	}

	@RequestMapping("/create")
	@ResponseBody
	String create() {
		User user = new User().randomize();
		user.setId(null);

		user = userClient.createUser(user);

		return String.format("Created a user with id %d", user.getId());
	}

	@RequestMapping("/read")
	@ResponseBody
	String read() {
		List<User> users = userClient.getUsers();

		return String.format("Retrieved %d users total", users.size());
	}

	@RequestMapping("/update")
	@ResponseBody
	String update() {
		User user = new User().randomize();
		String oldName = user.getName();
		user.setName("John");

		userClient.updateUser(1L, user);

		return String.format("Update successful. User id: %d, old name: %s, new name: %s",
			user.getId(), oldName, user.getName());
	}

	@RequestMapping("/delete")
	@ResponseBody
	String delete() {
		userClient.deleteUser(1L);

		return "Deleted";
	}
}
