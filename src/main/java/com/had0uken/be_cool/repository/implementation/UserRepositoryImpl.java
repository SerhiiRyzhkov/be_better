package com.had0uken.be_cool.repository.implementation;


import com.had0uken.be_cool.model.User;
import com.had0uken.be_cool.repository.AbstractRepository;
import com.had0uken.be_cool.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {
    @Override
    protected Session getSession() {
        return super.getSession();
    }

    @Override
    public List<User> getAll() {
        return getSession().createQuery("from User").list();
    }
}
