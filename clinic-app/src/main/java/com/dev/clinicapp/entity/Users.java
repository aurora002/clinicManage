package com.dev.clinicapp.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.dev.clinicapp.controller.Role;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@CreationTimestamp
	private LocalDateTime created_date;

	@UpdateTimestamp
	private LocalDateTime modified_date;

	private String username;
	private String email;
	private String password;
	
	@ManyToMany
	@JoinTable(
			name="doctor_patient",
			joinColumns= {@JoinColumn(name="doctor_id")}, 
			inverseJoinColumns= {@JoinColumn(name="patient_id")})
	private Set<Patient> patients = new HashSet<>();

	@Enumerated(EnumType.STRING)
	private Role role;

	public Users() {
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	public LocalDateTime getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}

	public LocalDateTime getModified_date() {
		return modified_date;
	}

	public void setModified_date(LocalDateTime modified_date) {
		this.modified_date = modified_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String string) {
		this.password = string;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
