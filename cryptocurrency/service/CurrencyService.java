package com.idfin.kusanov.cryptocurrency.service;

import com.idfin.kusanov.cryptocurrency.entity.Currency;

import java.util.List;

public interface CurrencyService {

    List<Currency> getAllCurrencies();

    double getCurrentPrice(String symbol);

}
