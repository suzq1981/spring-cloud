package com.badou.consul.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.badou.consul.user.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/{id}")
	public User get(@PathVariable("id") Integer userId) {
		return User.builder().userId(userId).username("William").build();
	}
}
