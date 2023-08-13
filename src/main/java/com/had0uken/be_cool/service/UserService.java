package com.had0uken.be_cool.service;

import com.had0uken.be_cool.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User get(String email);
    List<User> getAll();
    void banUser(User user);
    void unbanUser(User user);


}
