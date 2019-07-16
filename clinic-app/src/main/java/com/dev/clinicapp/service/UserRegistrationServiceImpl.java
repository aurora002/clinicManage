package com.dev.clinicapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.clinicapp.entity.Users;
import com.dev.clinicapp.model.dto.UserDTO;
import com.dev.clinicapp.repository.UserCrudRepository;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
	
	@Autowired
	private UserCrudRepository userCrudRepository;
	
	@Override
	public  Users create(Users userObj, UserDTO userDto) {	
		
		userObj.setPassword(userDto.getPassword());
		userObj.setUsername(userDto.getUsername());
		userObj.setEmail(userDto.getEmail());
		userObj.setRole(userDto.getRole());			
		return userCrudRepository.save(userObj);
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
