package com.badou.senior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import com.netflix.config.ConfigurationManager;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
		ConfigurationManager.getDeploymentContext().setDeploymentEnvironment("prod");
		ConfigurationManager.getDeploymentContext().setDeploymentDatacenter("Badou Cloud");
	}

}
