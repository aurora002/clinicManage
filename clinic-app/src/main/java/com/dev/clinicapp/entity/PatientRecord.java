package com.dev.clinicapp.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//change to one to many
@Entity
public class PatientRecord {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne(mappedBy = "patientRecord")
	@JoinColumn(name="patient_id",unique=true)
	private Patient patient;
	
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy="record")
	private Set<Treatment> treatments = new HashSet<>();
	
	protected PatientRecord() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public void addTreatment(Treatment treatment) {
		treatments.add(treatment);
		treatment.setRecord(this);
	}

	
}
