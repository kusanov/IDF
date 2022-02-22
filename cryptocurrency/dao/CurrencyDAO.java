package com.idfin.kusanov.cryptocurrency.dao;

import com.idfin.kusanov.cryptocurrency.entity.Currency;

import java.util.List;

public interface CurrencyDAO {
    List<Currency> getAllCurrencies();
}

