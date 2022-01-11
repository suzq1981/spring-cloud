package com.badou.consul.user.controller;

import java.util.concurrent.TimeUnit;

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
		long startTime = System.currentTimeMillis();
		while(true) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(System.currentTimeMillis() - startTime > 5000) {
				break;
			}
		}
		return User.builder().userId(userId).username("William").build();
	}
}
