package com.cognizant.iptreatmentofferings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class IpTreatmentOfferingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpTreatmentOfferingsApplication.class, args);
	}

}
