package com.badou.consul.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.badou.consul.order.entity.User;

@FeignClient(name = "badou-consul-user")
public interface UserFeignClient {

	@GetMapping("/user/{id}")
	User get(@PathVariable("id") Integer userId);

}
