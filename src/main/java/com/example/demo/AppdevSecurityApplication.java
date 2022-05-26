package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class AppdevSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppdevSecurityApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run(UserService userService){
//        return args -> {
//          userService.saveRole(new AppRole(null,"ROLE_USER"));
//          userService.saveRole(new AppRole(null,"ROLE_ADMIN"));
//
//          userService.saveUser(new AppUser(null, "user1", "password", true, new ArrayList<>()));
//          userService.saveUser(new AppUser(null, "admin1", "password", true, new ArrayList<>()));
//
//          userService.addRoleToUser("user1","ROLE_USER");
//          userService.addRoleToUser("admin1","ROLE_ADMIN");
//        };
//    }

}
