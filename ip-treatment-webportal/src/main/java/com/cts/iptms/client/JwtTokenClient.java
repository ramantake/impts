package com.cts.iptms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.iptms.model.JwtResponse;
import com.cts.iptms.model.User;



@FeignClient(url = "http://localhost:9090/Authentication", name = "TOKEN")
public interface JwtTokenClient {

	@PostMapping("/authenticate")
	public JwtResponse getJwt(@RequestBody User user);
}