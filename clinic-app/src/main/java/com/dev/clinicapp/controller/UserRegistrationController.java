package com.dev.clinicapp.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.clinicapp.entity.Users;
import com.dev.clinicapp.model.dto.BaseResponseObject;
import com.dev.clinicapp.model.dto.UserDTO;
import com.dev.clinicapp.service.UserRegistrationService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api/user"})
public class UserRegistrationController {

	@Autowired
	private UserRegistrationService userRegistrationservice;
	
	@PostMapping(path="/register")
	public ResponseEntity<?> create(@RequestBody  Users user){
		try {			
			Users userObj = new Users();
			Users registerUser = userRegistrationservice.create(userObj,user);
			BaseResponseObject baseResponseObject = new BaseResponseObject();
			baseResponseObject.setMessage("Username " + registerUser.getUsername()+ " is created.");
			return ResponseEntity.ok(baseResponseObject);
		}catch (Exception e) {
			String errMessage = e.getMessage();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errMessage);			
		}
		
	}
}
