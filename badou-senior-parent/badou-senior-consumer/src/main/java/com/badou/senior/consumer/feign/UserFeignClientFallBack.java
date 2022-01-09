package com.badou.senior.consumer.feign;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.badou.senior.consumer.entity.User;
import com.badou.senior.consumer.utils.ResultUtils;

@Component
public class UserFeignClientFallBack implements UserFeignClient {

	@Override
	public User get(Integer id) {
		return User.builder().age(0).name("").id(0).build();
	}

	@Override
	public User post(User user) {
		return User.builder().age(0).name("").id(0).build();
	}

	@Override
	public Map<String, Object> delete(Integer id) {
		return ResultUtils.NOT_OK;
	}

	@Override
	public Map<String, Object> put(User user) {
		return ResultUtils.NOT_OK;
	}

	@Override
	public List<User> qry(User condition) {
		List<User> users = new ArrayList<>();
		users.add(User.builder().age(0).name("").id(0).build());
		return users;
	}

}
