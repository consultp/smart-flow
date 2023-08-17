package com.cp.service;

import com.cp.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public String registerAccount(User user);
}
