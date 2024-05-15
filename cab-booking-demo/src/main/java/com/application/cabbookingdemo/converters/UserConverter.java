package com.application.cabbookingdemo.converters;

import com.application.cabbookingdemo.dtos.requests.UserRequestDTO;
import com.application.cabbookingdemo.entity.User;
import com.application.cabbookingdemo.exceptions.UserNameNotFoundException;

public class UserConverter {
	
	public static User convertDtotoEntity(UserRequestDTO userRequest){ 
		if(userRequest.getUsername()!= null) {
			 User userResponse = new User(userRequest.getUsername(), userRequest.getSex()
																	, userRequest.getAge());

			 return userResponse;
		}
		throw new UserNameNotFoundException("UserName is null/not found");
	}
	
	/*
	 * public static UserResponseDTO convertEntityToDto(UserRequestDTO userRequest)
	 * { UserResponseDTO userResponse = UserResponseDTO.builder()
	 * .username(userRequest.getUsername()) .build();
	 * 
	 * return userResponse; }
	 * 
	 * 
	 * 							User.builder()
				 				.userName(userRequest.getUsername())
				 				.sex(userRequest.getSex())
				 				.age(userRequest.getAge())
				 				.build();
	 */
}
