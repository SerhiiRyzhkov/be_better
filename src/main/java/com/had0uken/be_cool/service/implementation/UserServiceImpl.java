package com.had0uken.be_cool.service.implementation;

import com.had0uken.be_cool.model.Role;
import com.had0uken.be_cool.model.User;
import com.had0uken.be_cool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.had0uken.be_cool.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService,UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user =  userRepository.findById(s);
        if (user == null) throw new UsernameNotFoundException("Invalid email or password");
        List<GrantedAuthority> authorityList = new ArrayList<>();

        for (Role role : user.getRoleSet())
            authorityList.add(new SimpleGrantedAuthority(role.getRoleName()));
        return new org.springframework.security.core.userdetails.User(s, user.getPassword(), user.getEnabled(), true, true, true, authorityList);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
