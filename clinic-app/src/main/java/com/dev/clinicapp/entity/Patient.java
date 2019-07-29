package com.dev.clinicapp.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@CreationTimestamp
	private LocalDateTime created_date;
	
	@UpdateTimestamp
	private LocalDateTime modified_date;
	
	@OneToOne(fetch= FetchType.LAZY, mappedBy="patient")
	private PatientRecord patientRecord;
	
	private String name;
	private String address;
	private int age;
	private String gender;
	
	@ManyToMany(mappedBy="patients")
	private Set<Users> user = new HashSet<>();
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	private int phoneNumber;
	private String ic;
	
	protected Patient() {}
	
	public Set<Users> getUser() {
		return user;
	}

	public void setUser(Set<Users> user) {
		this.user = user;
	}

	public PatientRecord getPatientRecord() {
		return patientRecord;
	}
	
	public void setPatientRecord(PatientRecord patientRecord) {
		this.patientRecord = patientRecord;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getIc() {
		return ic;
	}
	
	public void setIc(String ic) {
		this.ic = ic;
	}
	
	public void addDoctor(Users user) {
        this.user.add(user);
        user.getPatients().add(this);
    }
	
	@Override
	public String toString() {
		return String.format("Patient[id=%d, name='%s', age=%d]", id, name, age);
	}
}
