package com.idfin.kusanov.cryptocurrency.service;

import com.idfin.kusanov.cryptocurrency.entity.UserRegistration;

import java.util.List;

public interface UserRegistrationService {

    List<UserRegistration> getAllUserRegistrations();

    UserRegistration save(UserRegistration newRegistration);

}
