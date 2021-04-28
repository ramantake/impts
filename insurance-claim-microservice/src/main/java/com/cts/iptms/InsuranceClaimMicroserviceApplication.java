package com.cts.iptms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class InsuranceClaimMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(InsuranceClaimMicroserviceApplication.class, args);
	}
}
