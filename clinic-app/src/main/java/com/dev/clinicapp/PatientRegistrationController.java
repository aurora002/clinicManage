package com.dev.clinicapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping({"/rest"})
public class PatientRegistrationController {
    @Autowired
    PatientRegistrationService service;
	
	@GetMapping(path = {"/{id}"})
	public Patient findById (@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@GetMapping
	public List<Patient> findAll() {
		return service.findAll();
	}
}
