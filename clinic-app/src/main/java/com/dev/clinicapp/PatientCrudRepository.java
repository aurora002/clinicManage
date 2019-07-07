package com.dev.clinicapp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientCrudRepository extends JpaRepository<Patient, Integer> {
        
	
}
