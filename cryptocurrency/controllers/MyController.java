package com.idfin.kusanov.cryptocurrency.controllers;

import com.idfin.kusanov.cryptocurrency.entity.Currency;
import com.idfin.kusanov.cryptocurrency.entity.UserRegistration;
import com.idfin.kusanov.cryptocurrency.service.CurrencyService;
import com.idfin.kusanov.cryptocurrency.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class MyController {

    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private UserRegistrationService userRegistrationService;

        @GetMapping("/currencies")
        public List<Currency> showAllCurrencies() {
            List<Currency> allCurrencies = currencyService.getAllCurrencies();
            return allCurrencies;
        }
    @GetMapping("/currencies/{symbol}")
    public double getCurrentPrice(@PathVariable String symbol) {
        return currencyService.getCurrentPrice(symbol);
    }
    @GetMapping("/user-registrations")
    public List<UserRegistration> showAllUserRegistrations() {
        List<UserRegistration> userRegistrations = userRegistrationService.getAllUserRegistrations();
        return userRegistrations;
    }

    @PostMapping(path = "/user-registrations",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRegistration> createUserRegistration(@RequestBody UserRegistration newRegistration) {
            UserRegistration userRegistration = userRegistrationService.save(newRegistration);
        return new ResponseEntity<>(userRegistration, HttpStatus.CREATED);
    }

}
