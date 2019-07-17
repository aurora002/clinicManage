package com.dev.clinicapp.service;


import com.dev.clinicapp.entity.Users;
import com.dev.clinicapp.model.dto.UserDTO;

public interface UserRegistrationService {

	Users create(Users user, Users userDto);
    Users findByUsername (String name);
    Users findByUsernameAndId (String name, Integer id);

}
