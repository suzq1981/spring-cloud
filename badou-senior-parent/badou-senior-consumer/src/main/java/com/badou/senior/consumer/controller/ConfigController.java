package com.badou.senior.consumer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

	@Value("${server.port}")
	private String port;

	@Value("${spring.application.name}")
	private String appName;

	@GetMapping("/profile")
	public Map<String, Object> config() {
		Map<String, Object> map = new HashMap<>();
		map.put("port", port);
		map.put("applicationName", appName);

		return map;
	}

}
