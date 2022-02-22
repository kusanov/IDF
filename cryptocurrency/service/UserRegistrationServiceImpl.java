package com.idfin.kusanov.cryptocurrency.service;

import com.idfin.kusanov.cryptocurrency.dao.UserRegistrationDAO;
import com.idfin.kusanov.cryptocurrency.entity.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRegistrationDAO userRegistrationDAO;

    @Override
    public List<UserRegistration> getAllUserRegistrations() {
        return userRegistrationDAO.getAllUserRegistrations();
    }

    @Override
    @Transactional
    public UserRegistration save(UserRegistration newRegistration) {
        System.out.println("new registration," + newRegistration.getUsername());
        return userRegistrationDAO.save(newRegistration);
    }
}

