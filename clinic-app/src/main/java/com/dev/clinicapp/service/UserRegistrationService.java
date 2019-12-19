package com.dev.clinicapp.service;


import java.util.List;

import com.dev.clinicapp.controller.Role;
import com.dev.clinicapp.entity.Users;
import com.dev.clinicapp.model.dto.UserDTO;

public interface UserRegistrationService {

	Users create(Users user, UserDTO userDto);
    Users findByUsername (String name);
    Users findByUsernameAndId (String name, Integer id);
    List<Users> findByRole(Role role);


}
