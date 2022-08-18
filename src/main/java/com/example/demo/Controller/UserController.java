package com.example.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.ResponseTemplateDto;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		LOGGER.info("Inside in save User");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{userId}")
	public ResponseTemplateDto getUser(@PathVariable Long userId) {
		LOGGER.info("Inside in get User");
		return userService.getUser(userId);
	}
}
