package com.cp.sf.Service;

import com.cp.sf.Exception.ResourceNotFoundException;
import com.cp.sf.Repository.USerRepo;
import com.cp.sf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements IUserService{

    @Autowired
    private USerRepo repo;

    @Override
    public List<User> fetchdetails() {
        return repo.findAll();
    }

    @Override
    public User registerdetails(User user) {
        return repo.save(user);
    }

    @Override
    public ResponseEntity<User> findbyid(Long id) {
        User user=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Userdoesnotexist with this id"+id));
        return ResponseEntity.ok(user);

    }

    @Override
    public ResponseEntity<User> Updateuser(Long id, User user) {
        User user1=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Id not found"+id));
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setMailid(user.getMailid());

        repo.save(user1);
        return ResponseEntity.ok(user1);
    }

    @Override
    public ResponseEntity<HttpStatus> deletebyid(Long id) {

        User user=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Id doesnot exist"+id));

        repo.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
