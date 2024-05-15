package com.application.cabbookingdemo.dtos.requests;

import com.application.cabbookingdemo.entity.Sex;

import lombok.Data;

@Data
public class UserRequestDTO {

	private String username;
	private Sex sex;
	private int age;
	
}
