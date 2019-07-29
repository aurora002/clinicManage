package com.dev.clinicapp.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.clinicapp.entity.Patient;
import com.dev.clinicapp.entity.Users;
import com.dev.clinicapp.model.dto.BaseResponseObject;
import com.dev.clinicapp.model.dto.LoginForm;
import com.dev.clinicapp.model.dto.UserDTO;
import com.dev.clinicapp.repository.PatientCrudRepository;
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
	
	@Autowired
	private PatientCrudRepository patientCrudRepository;
	
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
	
	@PutMapping(path="/assign/{doctor_id}/{patient_id}")
	public ResponseEntity<?> assign( @PathVariable("patient_id") int patient_id, 
			@PathVariable("doctor_id") int doctor_id) {
		BaseResponseObject response = new BaseResponseObject();
		
		Patient patient = patientCrudRepository.findById(patient_id).get();
		Users user = userCrudRepository.findById(doctor_id);
		
		user.getPatients().add(patient);
		patient.getUser().add(user);
		
		userCrudRepository.save(user);
		 
		response.setMessage("Doctor " + doctor_id + " has been assigned to patient " + patient_id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(path="/retrieve/{doctor_id}") 
	public Set<Patient> retrievePatientListAssigned (@PathVariable("doctor_id") int doctor_id){
		Users user = userCrudRepository.findById(doctor_id);
		Set<Patient> patients = user.getPatients();
		
		return patients;
	}
	
	@PostMapping(path="/login")
	public ResponseEntity<?> authenticate(@RequestBody LoginForm form) {
		authenticationManager.
			authenticate(new UsernamePasswordAuthenticationToken(form.getEmail(), form.getPassword()));
	
		final UserDetails userDetails = userDetailsService.loadUserByUsername(form.getEmail());
		
		final String jwt = jwtnUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername()));
		
	}
}
