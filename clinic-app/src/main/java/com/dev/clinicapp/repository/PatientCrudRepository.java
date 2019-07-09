package com.dev.clinicapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.clinicapp.entity.Patient;

public interface PatientCrudRepository extends JpaRepository<Patient, Integer> {
        
	Patient findByName(String name);
	Patient findByNameAndId(String name, Integer id);
	
}
