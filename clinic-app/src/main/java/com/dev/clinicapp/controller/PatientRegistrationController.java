package com.dev.clinicapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.clinicapp.entity.Patient;
import com.dev.clinicapp.service.PatientRegistrationService;

@RestController
@RequestMapping({"/rest"})
public class PatientRegistrationController {
    
	@Autowired
    private PatientRegistrationService service;
	
	@GetMapping(path = {"/{id}"})
	public Patient findById (@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@PostMapping
	public Patient create(@RequestBody Patient patient) {
		return service.create(patient);
	}
	
	@DeleteMapping(path = {"{/id}"})
	public Patient delete(int id) {
		return service.delete(id);
	}
	
	@GetMapping
	public List<Patient> findAll() {
		return service.findAll();
	}
}
