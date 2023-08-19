package com.cp.controller;

import com.cp.entity.User;
import com.cp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController implements UserService{
    @Autowired
    private UserService userservice;

    @PostMapping("/users")
    @Override
    public String registeruser(@Validated @RequestBody User user) {
        return userservice.registeruser(user);
    }
  @GetMapping("/users")
    @Override
    public Iterable<User> Fetchusers() {
        return userservice.Fetchusers();
    }
     @PutMapping("/users")
    @Override
    public String Updateuserdetails(@RequestBody User user) {
        return userservice.Updateuserdetails(user);
    }

    @DeleteMapping("/users/{id}")
    @Override
    public String removeUserbyId(List<Integer> ids) {
        return userservice.removeUserbyId(ids)+"deleted successfully" ;
    }

}
