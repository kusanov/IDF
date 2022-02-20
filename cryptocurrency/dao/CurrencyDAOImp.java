package com.idfin.kusanov.cryptocurrency.dao;

import com.idfin.kusanov.cryptocurrency.entity.Currency;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CurrencyDAOImp implements CurrencyDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Currency> getAllCurrencies() {
        Session session= entityManager.unwrap(Session.class);
        Query<Currency> query = session.createQuery("from Currency",Currency.class);
        List<Currency> allEmployees = query.getResultList();

        return allEmployees;    }

}
