package com.idfin.kusanov.cryptocurrency.dao;

import com.idfin.kusanov.cryptocurrency.entity.Currency;
import com.idfin.kusanov.cryptocurrency.entity.UserRegistration;

import java.util.List;

public interface UserRegistrationDAO {
    public UserRegistration save(UserRegistration newRegistration);

    public List<UserRegistration> getAllUserRegistrations();
//
//    public void saveCurrency(Currency currency);
//
//    public Currency getCurrency (int id);
//
//    public void deleteCurrency(int id);
}

