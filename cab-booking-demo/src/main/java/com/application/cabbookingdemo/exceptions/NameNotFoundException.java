package com.application.cabbookingdemo.exceptions;

public class NameNotFoundException extends RuntimeException {

	public NameNotFoundException() {
	}
	
	public NameNotFoundException(String message) {
		super(message);
	}
	
}
