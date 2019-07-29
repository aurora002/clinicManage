package com.dev.clinicapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.clinicapp.entity.Users;

@Repository
public interface  UserCrudRepository extends JpaRepository<Users , Integer>{

	Users findByUsername(String name);
	Users findByUsernameAndId( String name, Integer id);
	Users findByEmail(String email);
	Users findById(int id);
	
}
