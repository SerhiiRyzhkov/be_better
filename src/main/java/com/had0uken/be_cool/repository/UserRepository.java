package com.had0uken.be_cool.repository;

import com.had0uken.be_cool.model.User;

import java.io.Serializable;
import java.util.List;

public interface UserRepository extends EntityRepository<User>{
    List<User> getAll();

    boolean isPresent(Serializable id);
}
