package com.cp.sf.Service;

import com.cp.sf.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

public interface IUserService {
    // Used to fetch all the records
    public List<User> fetchdetails();

    // insert the records
    public User registerdetails(User user);

    //fetch details by usename
    public ResponseEntity<User> Fetchuserbyname(String username);

    // update details by username
    public ResponseEntity<User> UpdateuserByname(String username, User user);

    // Delete records
    public ResponseEntity<HttpStatus> deleteuser(String username);

    // Login purpose
    public String authencatedUser(User user);

    //checking Dupilecates
    public List<Object> CheckingDupilcateemailandmobileno();

    // Fetching user details exceptpassword
    public List<Object> Userdetailsexceptpassword();


    public void softdelete1(String username);

    public List<User> searchusers(String username,String mailid);


}


