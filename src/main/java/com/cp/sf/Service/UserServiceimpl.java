package com.cp.sf.Service;

import com.cp.sf.Controller.TestController;
import com.cp.sf.Exception.ResourceNotFoundException;
import com.cp.sf.Exception.UserExistException;
import com.cp.sf.Exception.UserNotFoundException;
import com.cp.sf.Repository.USerRepo;
import com.cp.sf.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimpl implements IUserService {

    public static final Logger logger=  LoggerFactory.getLogger(UserServiceimpl.class);



    @Autowired
    private USerRepo repo;



    @Override
    public List<User> fetchdetails() {
        logger.debug("com.cp.sf.Service.UserServiceimpl:: fetchdetails() method starts");

        return repo.findAll();

    }

    @Override
    public User registerdetails(User user) {
        logger.debug("com.cp.sf.Service.UserServiceimpl:: registerdetails() method starts");

        User storeddetails = repo.findByUsername(user.getUsername());
        if (storeddetails != null) throw new UserExistException("user already exist");

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();


        String encryptpassword = bcrypt.encode(user.getPassword());
        logger.info("com.cp.sf.Service.UserServiceimpl:: registerdetails() method password encrypted successfully");

        String currentuser=user.getLoggedinuser();
        user.setCreatedby(currentuser);
        user.setTimezone(Calendar.getInstance().getTimeZone().getDisplayName());
        user.setPassword(encryptpassword);
        logger.debug("com.cp.sf.Service.UserServiceimpl:: registerdetails() method ends");


        return repo.save(user);
    }

    @Override
    public ResponseEntity<User> Fetchuserbyname(String username) {

        logger.debug("com.cp.sf.Service.UserServiceimpl:: Fetchuserbyname() method starts");

        User user = repo.findById(username).orElseThrow(() -> new ResourceNotFoundException("Userdoesnotexist with this id" + username));
        logger.debug("com.cp.sf.Service.UserServiceimpl:: Fetchuserbyname() method end");

        return ResponseEntity.ok(user);

    }

    @Override
    public ResponseEntity<User> UpdateuserByname(String username, User user) {
        logger.debug("com.cp.sf.Service.UserServiceimpl:: UpdateuserByname() method start");

        User user1 = repo.findById(username).orElseThrow(() -> new ResourceNotFoundException("Id not found" + username));
        logger.info("com.cp.sf.Service.UserServiceimpl:: UpdateuserByname() user exist");

        BCryptPasswordEncoder base64=new BCryptPasswordEncoder();
      String encryptpassword=base64.encode(user.getPassword());

        String modifieduser=user.getLoggedinuser();
        user1.setId(user.getId());
        user1.setPassword(encryptpassword);
        user1.setMailid(user.getMailid());
        user1.setMobileno(user.getMobileno());
        user1.setModifiedby(modifieduser);

        repo.save(user1);
        logger.debug("com.cp.sf.Service.UserServiceimpl:: UpdateuserByname() method end");

        return ResponseEntity.ok(user1);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteuser(String username) {
        logger.debug("com.cp.sf.Service.UserServiceimpl:: deleteuser() method start");


        User user = repo.findById(username).orElseThrow(() -> new ResourceNotFoundException("Id doesnot exist" + username));
        logger.info("com.cp.sf.Service.UserServiceimpl:: deleteuser() userexist");

        repo.delete(user);
        logger.debug("com.cp.sf.Service.UserServiceimpl:: deleteuser() method end");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public String authencatedUser(User user) throws UserNotFoundException {
        logger.debug("com.cp.sf.Service.UserServiceimpl:: authencatedUser() method start");

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        Optional<User> opuser = repo.findById(user.getUsername());
        logger.info("com.cp.sf.Service.UserServiceimpl:: authencatedUser() user exist");

        if (opuser.isPresent()) {
            User dbuser = opuser.get();
            if (bcrypt.matches(user.getPassword(), dbuser.getPassword())) return "Login Successfully";

            else return "inccorrect Password";

        } else {
            logger.error("com.cp.sf.Service.UserServiceimpl:: authencatedUser() user does not exist");

            throw new UserNotFoundException("no user is not found with this name");

        }

    }

    @Override
    public List<Object> CheckingDupilcateemailandmobileno() {
        return repo.searchDuplicatesinEmailAndPassword();
    }




    @Override
    public void softdelete1(String username) {
        logger.debug("com.cp.sf.Service.UserServiceimpl:: softdelete1() method start");

        Optional<User> optional = repo.findById(username);

        if (optional.isPresent()) {
            logger.info("com.cp.sf.Service.UserServiceimpl:: softdelete1() userexist");

            User user = optional.get();
            user.setActive(0);
            logger.debug("com.cp.sf.Service.UserServiceimpl:: softdelete1() method end");

            repo.save(user);
        }
    }

    @Override
    public List<User> searchusers(String username, String mailid) {
        logger.debug("com.cp.sf.Service.UserServiceimpl::  searchusers() method start");

        return repo.findByUsernameOrMailid(username,mailid);
    }


}
