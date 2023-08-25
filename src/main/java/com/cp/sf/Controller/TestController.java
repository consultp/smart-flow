package com.cp.sf.Controller;

import com.cp.sf.Service.IUserService;
import com.cp.sf.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.SplittableRandom;

@RestController
@RequestMapping
public class TestController {
    @Autowired
    private IUserService service;
    private String username;
    private String mailid;


    @GetMapping()
    public List<User> fetchdetails() {
        return service.fetchdetails();
    }

    @PostMapping
    public User createuser(@RequestBody User user) {
        return service.registerdetails(user);

    }

    @GetMapping("{username}")
    public ResponseEntity<User> fetchbyname(@PathVariable String username) {


        return service.Fetchuserbyname(username);
    }

    @PutMapping("{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User user) {
        return service.UpdateuserByname(username, user);
    }

    @DeleteMapping("/hard/{username}")
    public ResponseEntity<HttpStatus> deletebyname(@PathVariable String username) {

        return service.deleteuser(username);
    }

    @PostMapping("/authenticateuser")
    public String authenticateUser(@RequestBody User user) {
        return service.authencatedUser(user);
    }


    @GetMapping("/duplicates")
    public List<Object> checkdupilecates() {
        return service.CheckingDupilcateemailandmobileno();
    }

    @GetMapping("/exceptpassword")
    public List<Object> Getallusersexceptpasswo() {
        return service.Userdetailsexceptpassword();
    }

    @PutMapping("/soft/{username}")
    public void softdelete1(@PathVariable String username) {
        System.out.println(username + "we passed argument");
        service.softdelete1(username);
    }

    @GetMapping("/search/username/mailid")
    public ResponseEntity<List<User>> combinations(
                                                   @RequestParam(name="username",required = false) String username,
                                                   @RequestParam(name="mailid",required = false) String mailid ) {



        return ResponseEntity.ok(service.searchusers(username,mailid));


    }

}

