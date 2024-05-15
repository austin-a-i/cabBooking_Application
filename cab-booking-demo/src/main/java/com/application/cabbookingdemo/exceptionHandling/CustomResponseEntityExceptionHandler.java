package com.application.cabbookingdemo.exceptionHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.application.cabbookingdemo.exceptions.NoCabFoundException;
import com.application.cabbookingdemo.exceptions.NameNotFoundException;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse errorDetails = new ExceptionResponse(LocalDateTime.now(), 
											ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NameNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNameNotFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse errorDetails = new ExceptionResponse(LocalDateTime.now(), 
											ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoCabFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNoCabFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse errorDetails = new ExceptionResponse(LocalDateTime.now(), 
											ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
