package com.dev.clinicapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.clinicapp.entity.Users;
import com.dev.clinicapp.model.dto.BaseResponseObject;
import com.dev.clinicapp.service.UserRegistrationService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api/user"})
public class UserRegistrationController {

	@Autowired
	private UserRegistrationService userRegistrationservice;
	
	@GetMapping(path="/register")
	public ResponseEntity<?> create(@RequestBody Users user){
		
		Users registerUser = userRegistrationservice.create(user);
		BaseResponseObject baseResponseObject = new BaseResponseObject();
		baseResponseObject.setMessage(" Created User "+ registerUser.getUsername());
		
		return ResponseEntity.ok(baseResponseObject);
		
	}
}
