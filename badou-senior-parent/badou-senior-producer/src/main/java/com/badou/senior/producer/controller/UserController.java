package com.badou.senior.producer.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.badou.senior.producer.entity.User;
import com.badou.senior.producer.service.DepartmentService;
import com.badou.senior.producer.utils.ResultUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/{id}")
	public User get(@PathVariable Integer id) {
		User user = User.builder().id(id).age(20).name("William").build();
		return user;
	}

	@PostMapping
	public User post(@RequestBody User user) {
		user.setName(user.getName() + " Su");
		return user;
	}

	@DeleteMapping
	public Map<String, Object> delete(Integer id) {
		System.out.println("user id=" + id);
		return ResultUtils.OK;
	}

	@PutMapping
	public Map<String, Object> put(@RequestBody User user) {
		System.out.println(user);
		return ResultUtils.OK;
	}

	@PostMapping("/image")
	public Map<String, Object> image(@RequestParam("image") MultipartFile file, User user) {
		System.out.println(user);
		if (!file.isEmpty()) {
			// 获取文件存储路径（绝对路径）
			String path = "D:\\test";
			// 获取原文件名
			String fileName = file.getOriginalFilename();
			// 创建文件实例
			File filePath = new File(path, fileName);
			// 如果文件目录不存在，创建目录
			if (!filePath.getParentFile().exists()) {
				filePath.getParentFile().mkdirs();
				System.out.println("创建目录" + filePath);
			}
			// 写入文件
			try {
				file.transferTo(filePath);
			} catch (Exception e) {
				return ResultUtils.NOT_OK;
			}
		}
		return ResultUtils.OK;
	}

	public List<User> fallbackQry(User condition) {
		System.out.println("start fallbackQry: " + Thread.currentThread().getName());
		System.out.println("count: " + count.get());
		return new ArrayList<User>();

	}

	private AtomicInteger count = new AtomicInteger(0);

	// HystrixCommandProperties
	@HystrixCommand(fallbackMethod = "fallbackQry", commandProperties = {
			@HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED, value = "true"),
			@HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value = "10"),
			@HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "600000"),
			@HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_STRATEGY, value = "THREAD"),
			@HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "3000")

	})
	@RequestMapping(value = "/qry", method = { RequestMethod.GET, RequestMethod.POST })
	public List<User> qry(User condition) throws Exception {
		List<User> users = new ArrayList<User>();
		users.add(User.builder().id(1).age(20).name("William").build());
		users.add(User.builder().id(2).age(21).name("Lucy").build());
		users.add(User.builder().id(3).age(22).name("Jack").build());
		System.out.println("start qry: " + Thread.currentThread().getName());
		count.incrementAndGet();
		departmentService.autoBatchCreateDepart();
		System.out.println("end qry: " + Thread.currentThread().getName());
		return users;
	}

}
