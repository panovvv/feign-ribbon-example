package com.shortn0tes.feignexample.feign;

import com.shortn0tes.feignexample.model.User;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created on 1/15/2018.
 */
@FeignClient("user-client")
public interface UserClient {

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	User createUser(User user);

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	List<User> getUsers();

	@RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
	User getUser(@PathVariable("userId") Long userId);

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}")
	User updateUser(@PathVariable("userId") Long userId, User user);

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
	void deleteUser(@PathVariable("userId") Long userId);
}
