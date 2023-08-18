package com.cp.service;

import com.cp.entity.User;
import com.cp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimpl implements UserService{

    @Autowired
    private UserRepo repo;

    @Override
    public String registeruser(User user) {
        return repo.save(user).getUserid()+"  registered with id";
    }

    @Override
    public Iterable<User> Fetchusers() {
        return repo.findAll();
    }

    @Override
    public String Updateuserdetails(User user) {
        Optional<User> opt=repo.findById(user.getUserid());

        if(opt.isPresent()){
            repo.save(user);
            return user.getUserid()+"doctor details are found";

        }else{
            return "User is registred with new id values"+repo.save(user).getUserid();
        }
    }

    @Override
    public String removeUserbyId(List<Integer> ids) {

        List<User> users = (List<User>) repo.findAllById(ids) ;
        if (users.size() == ids.size()) {
            repo.deleteAllById(ids);
            return users.size() + "records are deleted";
        } else {

            return "some of id or records are not found in db table";
        }


    }
}



