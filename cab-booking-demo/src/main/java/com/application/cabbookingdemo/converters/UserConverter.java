package com.application.cabbookingdemo.converters;

import com.application.cabbookingdemo.dtos.requests.UserRequestDTO;
import com.application.cabbookingdemo.entity.User;
import com.application.cabbookingdemo.exceptions.NameNotFoundException;

public class UserConverter {
	
	public static User convertDtotoEntity(UserRequestDTO userRequest){ 
		if(userRequest.getUsername()!= null) {
			 User userResponse = new User(userRequest.getUsername(), userRequest.getSex()
																	, userRequest.getAge());

			 return userResponse;
		}
		throw new NameNotFoundException("UserName is null/not found");
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
