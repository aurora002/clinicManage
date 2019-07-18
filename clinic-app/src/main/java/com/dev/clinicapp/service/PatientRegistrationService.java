package com.dev.clinicapp.service;

import java.util.List;

import com.dev.clinicapp.controller.PatientNotFoundException;
import com.dev.clinicapp.entity.Patient;

public interface PatientRegistrationService {
   
	Patient create (Patient p);
    Patient delete (int id);
    Patient findById (int id) throws PatientNotFoundException;
    Patient findByName (String name);
    Patient findByNameAndId (String name, Integer id);
    List<Patient> findAll();
    
}
