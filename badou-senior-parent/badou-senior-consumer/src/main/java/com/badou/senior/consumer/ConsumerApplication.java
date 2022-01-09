package com.badou.senior.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClients(defaultConfiguration = RibbonClientConfiguration.class, value = {
//		@RibbonClient(name = "badou-cloud-producer", configuration = BadouRibbonClientConfiguration.class) })
@EnableFeignClients
@EnableHystrix
public class ConsumerApplication {

	@Bean
	@LoadBalanced
	public RestTemplate balanceRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
