package com.badou.senior.consumer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.badou.senior.consumer.entity.User;
import com.badou.senior.consumer.feign.UserFeignClient;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserFeignClient userFeignClient;

	@Autowired
	@Qualifier("balanceRestTemplate")
	private RestTemplate restTemplate;

	@GetMapping("/{id}")
	public User get(@PathVariable Integer id) {
		User user = userFeignClient.get(id);
		return user;
	}

	@PostMapping
	public User post(@RequestBody User user) {
		return userFeignClient.post(user);
	}

	@PutMapping
	public Map<String, Object> put(@RequestBody User user) {
		return userFeignClient.put(user);
	}

	@DeleteMapping
	public Map<String, Object> delete(Integer id) {
		System.out.println(id);
		return userFeignClient.delete(id);
	}

	@PostMapping("/qry")
	public List<User> qry(User condition) {
		return userFeignClient.qry(condition);
	}

}
