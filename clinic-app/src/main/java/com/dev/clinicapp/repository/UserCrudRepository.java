package com.dev.clinicapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.clinicapp.entity.Users;

@Repository
public interface  UserCrudRepository extends JpaRepository<Users , Integer>{

	Users findByName(String name);
	Users findByNameAndId( String name, Integer id);
	
}
