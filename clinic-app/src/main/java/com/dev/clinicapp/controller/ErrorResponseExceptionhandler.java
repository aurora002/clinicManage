package com.dev.clinicapp.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorResponseExceptionhandler {

	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(PatientNotFoundException ex, WebRequest rq) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), new Date());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> otherExceptionHandler(Exception ex, WebRequest rq) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), new Date());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
