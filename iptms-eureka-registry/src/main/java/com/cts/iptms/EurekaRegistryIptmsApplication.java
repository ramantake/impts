package com.cts.iptms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaRegistryIptmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRegistryIptmsApplication.class, args);
	}

}
