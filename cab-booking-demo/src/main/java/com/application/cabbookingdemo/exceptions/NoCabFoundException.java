package com.application.cabbookingdemo.exceptions;

public class NoCabFoundException extends RuntimeException {

	public NoCabFoundException() {
	}
	
	public NoCabFoundException(String message) {
		super(message);
	}
	
}