package com.dev.clinicapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.clinicapp.entity.Users;
import com.dev.clinicapp.model.dto.BaseResponseObject;
import com.dev.clinicapp.model.dto.LoginForm;
import com.dev.clinicapp.model.dto.UserDTO;
import com.dev.clinicapp.repository.UserCrudRepository;
import com.dev.clinicapp.service.UserRegistrationService;
import com.dev.clinicapp.util.JwtResponse;
import com.dev.clinicapp.util.JwtUtil;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api/user"})
public class UserRegistrationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtnUtil;
	
	@Autowired
	private UserRegistrationService userRegistrationservice;
	
	@Autowired
	private UserCrudRepository userCrudRepository;
	
	@PostMapping(path="/register")
	public ResponseEntity<?> create(@RequestBody  UserDTO user){
		BaseResponseObject baseResponseObject = new BaseResponseObject();
		
		if( userCrudRepository.findByUsername(user.getUsername()) != null) {
			baseResponseObject.setMessage(" Username already exist");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(baseResponseObject);
		}
		
		try {			
			Users userObj = new Users();
			Users registerUser = userRegistrationservice.create(userObj,user);
			
			baseResponseObject.setMessage("Username " + registerUser.getUsername()+ " is created.");
			return ResponseEntity.ok(baseResponseObject);
		}catch (Exception e) {
			String errMessage = e.getMessage();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errMessage);			
		}
		
	}
	
	@PostMapping(path="/login")
	public ResponseEntity<?> authenticate(@RequestBody LoginForm form) {
		authenticationManager.
			authenticate(new UsernamePasswordAuthenticationToken(form.getEmail(), form.getPassword()));
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(form.getEmail());
		
		final String jwt = jwtnUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(jwt));
		
	}
}
