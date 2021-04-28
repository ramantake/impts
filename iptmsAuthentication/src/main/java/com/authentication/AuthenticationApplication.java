package com.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.authentication.entity.User;
import com.authentication.repository.UserRepository;

@SpringBootApplication
public class AuthenticationApplication implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		User admin = new User("admin", "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK", "ROLE_ADMIN");
	
		userRepository.save(admin);
			
	}
}
