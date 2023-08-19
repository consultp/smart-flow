package com.cp.service;

import com.cp.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    public String registeruser(User user);
    public Iterable<User> Fetchusers();
    public String Updateuserdetails(User user);


    String removeUserbyId(List<Integer> ids);
}
