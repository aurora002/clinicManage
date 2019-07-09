package com.dev.clinicapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.clinicapp.entity.Patient;
import com.dev.clinicapp.repository.PatientCrudRepository;

@Service
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
		return patientCrudRepository.findByName(name);
	}

	@Override
	public List<Patient> findAll() {
		return patientCrudRepository.findAll();
	}

	@Override
	public Patient findById(int id) {
		return patientCrudRepository.findById(id).get();
	}

	@Override
	public Patient findByNameAndId(String name, Integer id) {
		return patientCrudRepository.findByNameAndId(name, id);
	}


}
