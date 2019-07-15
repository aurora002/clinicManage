package com.dev.clinicapp.service;


import com.dev.clinicapp.entity.Users;

public interface UserRegistrationService {

	Users create(Users user);
    Users findByUsername (String name);
    Users findByUsernameAndId (String name, Integer id);

}
