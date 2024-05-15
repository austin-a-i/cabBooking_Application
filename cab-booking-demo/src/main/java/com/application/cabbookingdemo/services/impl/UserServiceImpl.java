package com.application.cabbookingdemo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.application.cabbookingdemo.converters.UserConverter;
import com.application.cabbookingdemo.dtos.requests.UserRequestDTO;
import com.application.cabbookingdemo.entity.User;
import com.application.cabbookingdemo.repository.UserRepository;
import com.application.cabbookingdemo.services.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Transactional
	@Override
	public String createUser(UserRequestDTO userRequest) {
		User user = UserConverter.convertDtotoEntity(userRequest);
		//em.persist(user);
		userRepository.save(user);	
		return "User " + user.getUserName() + " has been added successfully ";
	}

}
