package com.application.cabbookingdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.cabbookingdemo.dtos.requests.UserRequestDTO;
import com.application.cabbookingdemo.entity.User;
import com.application.cabbookingdemo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public List<User> retrieveAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/add")
	public String addUser(@RequestBody UserRequestDTO user) {
        try{
            String createUser = userService.createUser(user);
            return createUser;
        } catch (Exception exception){
            return exception.getMessage();
        }
    }
	
}
