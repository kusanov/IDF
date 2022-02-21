package com.idfin.kusanov.cryptocurrency.dao;

import com.idfin.kusanov.cryptocurrency.entity.UserRegistration;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserRegistrationDAOImpl implements UserRegistrationDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public UserRegistration save(UserRegistration newRegistration) {
        return entityManager.merge(newRegistration);
    }

    @Override
    public List<UserRegistration> getAllUserRegistrations() {
        Session session= entityManager.unwrap(Session.class);
        Query<UserRegistration> query = session.createQuery("from UserRegistration",UserRegistration.class);
        List<UserRegistration> allUserRegistrations = query.getResultList();

        return allUserRegistrations;    }


}
