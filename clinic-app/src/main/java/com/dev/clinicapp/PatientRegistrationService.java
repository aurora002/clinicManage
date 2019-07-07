package com.dev.clinicapp;

import java.util.List;

public interface PatientRegistrationService {
   
	Patient create (Patient p);
    Patient delete (int id);
    Patient findById (int id);
    Patient findByName (String name);
    List<Patient> findAll();
    
}
