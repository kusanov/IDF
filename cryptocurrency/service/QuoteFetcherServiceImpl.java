package com.idfin.kusanov.cryptocurrency.service;

import com.idfin.kusanov.cryptocurrency.entity.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class QuoteFetcherServiceImpl implements QuoteFetcherService {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Quote getQuote(int currencyId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<List<Quote>> response = restTemplate.exchange("https://api.coinlore.net/api/ticker/?id=" + currencyId,
                HttpMethod.GET, entity, new ParameterizedTypeReference<List<Quote>>() {
                });
        System.out.println(currencyId);
        Quote quote = response.getBody().iterator().next();
        return quote;
    }
}
