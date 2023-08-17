package com.cp.service;

import com.cp.entity.User;
import com.cp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService{

    @Autowired
    private UserRepo repo;

    @Override
    public String registerAccount(User user) {

        User user1 = new User();

        return "account created with id od " + user1.getId();


    }

}
