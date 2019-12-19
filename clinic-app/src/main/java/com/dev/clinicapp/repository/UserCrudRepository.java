package com.dev.clinicapp.repository;

import java.util.List;

import com.dev.clinicapp.controller.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.clinicapp.entity.Users;

@Repository
public interface UserCrudRepository extends JpaRepository<Users , Integer>{

	Users findByUsername(String name);
	Users findByUsernameAndId( String name, Integer id);
	Users findByEmail(String email);
	List<Users> findByRole(Role role);
	Users findById(int id);
	
}
