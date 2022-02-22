package com.idfin.kusanov.cryptocurrency.service;

import com.idfin.kusanov.cryptocurrency.entity.Quote;

public interface QuoteFetcherService {
    Quote getQuote(int currencyId);
}

