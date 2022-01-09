package com.badou.senior.producer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaController {

	@Autowired
	private EurekaDiscoveryClient eurekaDiscoveryClient;

	@GetMapping("/einfo")
	public String einfo() {
		List<String> services = eurekaDiscoveryClient.getServices();
		for (String service : services) {
			System.out.println(service);
		}
		
		List<ServiceInstance> instances = eurekaDiscoveryClient.getInstances("badou-cloud-eureka");
		if (instances.size() > 0) {
			for (ServiceInstance instance : instances) {
				System.out.println("Host: " + instance.getHost() + ",Port: " + instance.getPort());
			}
		}
		return "Eureka info...";
	}

}
