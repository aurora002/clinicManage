package com.dev.clinicapp.service;

import java.util.List;

import com.dev.clinicapp.entity.Patient;

public interface PatientRegistrationService {
   
	void create (Patient p);
    Patient delete (int id);
    Patient findById (int id);
    Patient findByName (String name);
    Patient findByNameAndId (String name, Integer id);
    List<Patient> findAll();
    
}
