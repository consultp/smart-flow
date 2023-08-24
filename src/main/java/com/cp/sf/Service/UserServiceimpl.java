package com.cp.sf.Service;

import com.cp.sf.Exception.ResourceNotFoundException;
import com.cp.sf.Exception.UserExistException;
import com.cp.sf.Exception.UserNotFoundException;
import com.cp.sf.Repository.USerRepo;
import com.cp.sf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimpl implements IUserService{

    @Autowired
    private USerRepo repo;

    @Override
    public List<User> fetchdetails() {
        return repo.findAll();
    }

    @Override
    public User registerdetails(User user)
    {
        User storeddetails=repo.findByUsername(user.getUsername());
        if(storeddetails !=null) throw new UserExistException("user already exist");

        BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
        String encryptpassword=bcrypt.encode(user.getPassword());
        user.setPassword(encryptpassword);
        return repo.save(user);
    }

    @Override
    public ResponseEntity<User> Fetchuserbyname(String username){
        User user=repo.findById(username).orElseThrow(()->new ResourceNotFoundException("Userdoesnotexist with this id"+username));
        return ResponseEntity.ok(user);

    }

    @Override
    public ResponseEntity<User>UpdateuserByname(String username,User user) {
        User user1=repo.findById(username).orElseThrow(()->new ResourceNotFoundException("Id not found"+username));
      //  user1.setUsername(user.getUsername());

        user1.setPassword(user.getPassword());
        user1.setMailid(user.getMailid());
        user1.setMobileno(user.getMobileno());

        repo.save(user1);
        return ResponseEntity.ok(user1);
    }

    @Override
    public ResponseEntity<HttpStatus>  deleteuser(String username){

        User user=repo.findById(username).orElseThrow(()->new ResourceNotFoundException("Id doesnot exist"+username));

        repo.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public String authencatedUser(User user) throws UserNotFoundException {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        Optional<User> opuser = repo.findById(user.getUsername());
        if (opuser.isPresent()) {
            User dbuser = opuser.get();
            if (bcrypt.matches(user.getPassword(), dbuser.getPassword()))
                return "Login Successfully";
            else
                return "inccorrect Password";
        } else {


            throw new UserNotFoundException("no user is not found with this name");


        }

    }

    @Override
    public List<Object> CheckingDupilcateemailandmobileno() {
        return repo.searchDuplicatesinEmailAndPassword();
    }

    @Override
    public List<Object> Userdetailsexceptpassword() {
        return repo.getallUsersexceptpassword();
    }



    @Override
    public void softdelete1(String username) {
        Optional<User> optional = repo.findById(username);

        if (optional.isPresent()) {
            User user = optional.get();
            user.setActive(0);

             repo.save(user);
        }

    }

    @Override
    public ResponseEntity<List<User>> findByNameorMailorPhonenoorStatus(String username, String mailid, Long mobileno, Integer active) {
        return findByNameorMailorPhonenoorStatus(username,mailid,mobileno,active);
    }

}
