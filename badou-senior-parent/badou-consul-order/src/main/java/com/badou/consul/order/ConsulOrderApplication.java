package com.badou.consul.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.badou.consul.order.entity.StudentConfig;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableConfigurationProperties({StudentConfig.class})
public class ConsulOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulOrderApplication.class, args);
	}

}
