package com.cp.sf.Service;

import com.cp.sf.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {

    public List<User> fetchdetails();

    public User registerdetails(User user);

    public ResponseEntity<User> findbyid(Long id);

    public ResponseEntity<User> Updateuser(Long id,User user);

    public ResponseEntity<HttpStatus> deletebyid(Long id);
}
