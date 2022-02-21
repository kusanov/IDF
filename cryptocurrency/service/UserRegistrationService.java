package com.idfin.kusanov.cryptocurrency.service;

import com.idfin.kusanov.cryptocurrency.entity.Currency;
import com.idfin.kusanov.cryptocurrency.entity.UserRegistration;

import java.util.List;

public interface UserRegistrationService {

    public List<UserRegistration> getAllUserRegistrations();

    UserRegistration save(UserRegistration newRegistration);

//
//    public void saveCurrency(Currency currency);
//
//    public Currency getCurrency(int id);
//
//    public void deleteCurrency(int id);

}
