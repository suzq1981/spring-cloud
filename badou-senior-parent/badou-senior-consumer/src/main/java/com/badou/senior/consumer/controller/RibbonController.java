package com.badou.senior.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.badou.senior.consumer.entity.User;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/{id}")
	public User get(@PathVariable Integer id) {
		ServiceInstance instance = loadBalancerClient.choose("badou-cloud-producer");
		System.out.println(instance.getHost() + ":" + instance.getPort() + ", " + instance.getServiceId());
		ServiceInstance instance2 = loadBalancerClient.choose("badou-cloud-producer");
		System.out.println(instance2.getHost() + ":" + instance2.getPort() + ", " + instance2.getServiceId());
		User user = restTemplate.getForObject("http://badou-cloud-producer/user/" + id, User.class);
		return user;
	}

}
