package com.idfin.kusanov.cryptocurrency.service;

import com.idfin.kusanov.cryptocurrency.dao.CurrencyDAO;
import com.idfin.kusanov.cryptocurrency.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDAO currencyDAO;
    @Autowired
    private QuoteFetcherService quoteFetcherService;


    @Override
    public List<Currency> getAllCurrencies() {
        return currencyDAO.getAllCurrencies();
    }

    @Override
    public double getCurrentPrice(String symbol) {
        List<Currency> currencies = getAllCurrencies();
        int id = 0;
        for (Currency currency : currencies) {
            if (currency.getSymbol().equals(symbol)) {
                id = currency.getId();
            }
        }
        System.out.println(symbol + "," + id);
        return quoteFetcherService.getQuote(id).getPrice();
    }
}

