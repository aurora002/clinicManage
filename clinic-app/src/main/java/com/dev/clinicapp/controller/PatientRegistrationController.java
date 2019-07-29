package com.dev.clinicapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dev.clinicapp.entity.Patient;
import com.dev.clinicapp.service.PatientRegistrationService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api/patient"})
public class PatientRegistrationController {
    
	@Autowired
    private PatientRegistrationService service;
	
	@GetMapping("/patients")
	public List<Patient> getAllPatients() {
		return service.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Patient> findById (@PathVariable("id") int id) throws PatientNotFoundException {
		Patient patient = service.findById(id);
		return ResponseEntity.ok().body(patient);
	}
	
	@PostMapping(path="/register")
	public ResponseEntity<Object> create(@RequestBody Patient patient) {
		Patient registeredPatient = service.create(patient);
		
		System.out.println(ServletUriComponentsBuilder.fromCurrentRequest().toUriString());
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(registeredPatient.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = {"{/id}"})
	public ResponseEntity<?> delete(@PathVariable ("id") int id) {
		Patient patient = service.delete(id);
		return ResponseEntity.ok(patient);
	}
}
