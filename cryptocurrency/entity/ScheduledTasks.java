package com.idfin.kusanov.cryptocurrency.entity;

import java.text.SimpleDateFormat;
import java.util.*;

import com.idfin.kusanov.cryptocurrency.service.CurrencyService;
import com.idfin.kusanov.cryptocurrency.service.QuoteFetcherService;
import com.idfin.kusanov.cryptocurrency.service.UserRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Autowired
    private QuoteFetcherService quoteFetcherService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private UserRegistrationService userRegistrationService;

    @Scheduled(fixedRate = 60000)
    public void reportCurrentPrice() {

        List<Currency> currencyList = currencyService.getAllCurrencies();
        List<UserRegistration> userRegistrationList = userRegistrationService.getAllUserRegistrations();
        Map<String, List<UserRegistration>> mapUserReg = new HashMap<>();
        for (UserRegistration userRegistration : userRegistrationList) {
            String symbol = userRegistration.getSymbol();
            List<UserRegistration> userRegistrationListForCurrency = mapUserReg.get(symbol);
            if (userRegistrationListForCurrency == null) {
                userRegistrationListForCurrency = new ArrayList<UserRegistration>();
                mapUserReg.put(symbol, userRegistrationListForCurrency);
            }
            userRegistrationListForCurrency.add(userRegistration);
        }
        for (Currency currency : currencyList) {
            Quote quote = quoteFetcherService.getQuote(currency.getId());
            List<UserRegistration> userRegistrationListForCurrency = mapUserReg.get(currency.getSymbol());
            for (UserRegistration userRegistration : userRegistrationListForCurrency) {
                log.info(userRegistration.getUsername() + "," +userRegistration.getSymbol());
                double registrationPrice = userRegistration.getRegistrationPrice();
                if (quote.getPrice() >= registrationPrice * 1.01 || quote.getPrice() <= registrationPrice / 1.01) {
                    log.info(quote.getPrice() + "," + userRegistration.getRegistrationPrice());
                    log.warn(quote.getSymbol() + ", " + userRegistration.getUsername() + ", " +
                            (quote.getPrice() / userRegistration.getRegistrationPrice() - 1) * 100 + "%");
                }
            }
        }
    }

}
