package com.idfin.kusanov.cryptocurrency.dao;

import com.idfin.kusanov.cryptocurrency.entity.UserRegistration;

import java.util.List;

public interface UserRegistrationDAO {
    UserRegistration save(UserRegistration newRegistration);

    List<UserRegistration> getAllUserRegistrations();
}

