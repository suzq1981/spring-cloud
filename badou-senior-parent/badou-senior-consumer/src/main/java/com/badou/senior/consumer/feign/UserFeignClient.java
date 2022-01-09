package com.badou.senior.consumer.feign;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.badou.senior.config.BadouFeignClientsConfiguration;
import com.badou.senior.consumer.entity.User;

@FeignClient(name = "badou-cloud-producer", configuration = BadouFeignClientsConfiguration.class, fallback = UserFeignClientFallBack.class)
public interface UserFeignClient {

	@GetMapping("/user/{id}")
	public User get(@PathVariable Integer id);

	@PostMapping("/user")
	public User post(@RequestBody User user);

	@DeleteMapping("/user")
	public Map<String, Object> delete(Integer id);

	@PutMapping("/user")
	public Map<String, Object> put(@RequestBody User user);

	@PostMapping("/user/qry")
	public List<User> qry(User condition);
}
