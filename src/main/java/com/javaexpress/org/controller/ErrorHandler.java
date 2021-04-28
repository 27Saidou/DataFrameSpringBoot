package com.javaexpress.org.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.web.exception.ApplicationError;
import com.web.exception.UserNotFoundException;

@RestControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
public ResponseEntity<ApplicationError>userNotFoundException(UserNotFoundException ex,WebRequest webRequest){
	ApplicationError error=new ApplicationError();
	error.setCode(101);
	error.setMessage(ex.getMessage());
	return new  ResponseEntity<>(error,HttpStatus.NOT_FOUND);
}
}
