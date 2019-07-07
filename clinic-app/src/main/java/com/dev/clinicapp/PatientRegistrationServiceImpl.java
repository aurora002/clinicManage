package com.dev.clinicapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class PatientRegistrationServiceImpl implements PatientRegistrationService {

	@Autowired
	PatientCrudRepository patientCrudRepository;
	 
	@Override
	public Patient create(Patient patient) {
		return patientCrudRepository.save(patient);
	}

	@Override
	public Patient delete(int id) {
		Optional<Patient> patient = patientCrudRepository.findById(id);
		patientCrudRepository.delete(patient.get());
		return patient.get();
	}

	@Override
	public Patient findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> findAll() {
		return patientCrudRepository.findAll();
	}

	@Override
	public Patient findById(int id) {
		return patientCrudRepository.findById(id).get();
	}

}
