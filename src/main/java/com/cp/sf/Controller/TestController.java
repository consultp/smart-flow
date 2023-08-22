package com.cp.sf.Controller;

import com.cp.sf.Service.IUserService;
import com.cp.sf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TestController {
    @Autowired
    private IUserService service;

    @GetMapping("/new")
    public List<User> fetchdetails() {
        return service.fetchdetails();}

    @PostMapping
    public User createuser(@RequestBody User user){
        return service.registerdetails(user);

    }

    @GetMapping("{id}")
    public ResponseEntity<User> fetchbyid(@PathVariable Long id){
        return   service.findbyid(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
        return service.Updateuser(id,user);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletebyid(@PathVariable Long id){

        return service.deletebyid(id);
    }


}
