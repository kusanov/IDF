package com.idfin.kusanov.cryptocurrency.service;

import com.idfin.kusanov.cryptocurrency.dao.CurrencyDAO;
import com.idfin.kusanov.cryptocurrency.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDAO currencyDAO;

    @Override
    public List<Currency> getAllCurrencies() {
        return currencyDAO.getAllCurrencies();
    }
//
//    @Override
//    @Transactional
//    public void saveCurrency(Currency currency) {
//        currencyDAO.saveCurrency(currency);
//    }
//
//    @Override
//    @Transactional
//    public Currency getCurrency(int id) {
//        return currencyDAO.getCurrency(id);
//    }
//
//    @Override
//    @Transactional
//    public void deleteEmployee(int id) {
//        currencyDAO.deleteCurrency(id);

    }

