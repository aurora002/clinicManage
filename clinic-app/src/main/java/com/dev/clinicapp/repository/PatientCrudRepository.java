package com.dev.clinicapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.clinicapp.entity.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientCrudRepository extends JpaRepository<Patient, Integer> {
        
	Patient findByName(String name);
	Patient findByNameAndId(String name, Integer id);
	
}
