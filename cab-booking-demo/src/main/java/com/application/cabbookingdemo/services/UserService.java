package com.application.cabbookingdemo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.cabbookingdemo.dtos.requests.UserRequestDTO;
import com.application.cabbookingdemo.entity.User;

@Service
public interface UserService {

	List<User> getAllUsers();

	String createUser(UserRequestDTO user);

}
