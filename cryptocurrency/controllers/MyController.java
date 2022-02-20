package com.idfin.kusanov.cryptocurrency.controllers;

import com.idfin.kusanov.cryptocurrency.entity.Currency;
import com.idfin.kusanov.cryptocurrency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api")
public class MyController {

    @Autowired
    private CurrencyService currencyService;

        @GetMapping("/currencies")
        public List<Currency> snowAllCurrencies () {
            List<Currency> allCurrencies = currencyService.getAllCurrencies();
            return allCurrencies;
        }
}
