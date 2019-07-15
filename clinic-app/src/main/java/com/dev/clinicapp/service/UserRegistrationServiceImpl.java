package com.dev.clinicapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.clinicapp.entity.Users;
import com.dev.clinicapp.repository.UserCrudRepository;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
	
	@Autowired
	private UserCrudRepository userCrudRepository;

	@Override
	public  Users create(Users user) {
		return userCrudRepository.save(user);
		
	}

	@Override
	public Users findByUsername(String name) {
		// TODO Auto-generated method stub
		return userCrudRepository.findByUsername(name);
	}

	@Override
	public Users findByUsernameAndId(String name, Integer id) {
		// TODO Auto-generated method stub
		return userCrudRepository.findByUsernameAndId(name, id);
	}

}
