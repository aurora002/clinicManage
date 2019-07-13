package com.dev.clinicapp.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class ErrorResponseExceptionhandler {

	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(PatientNotFoundException ex) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), new Date());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> otherExceptionHandler(Exception ex) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), new Date());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
