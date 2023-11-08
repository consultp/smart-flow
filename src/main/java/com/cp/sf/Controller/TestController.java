package com.cp.sf.Controller;

import com.cp.sf.Service.IUserService;
import com.cp.sf.Entity.User;
import org.hibernate.mapping.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class TestController {

    public static final Logger logger=  LoggerFactory.getLogger(TestController.class);



    @Autowired
    private IUserService service;


    @GetMapping
    public List<User> fetchdetails() {
        logger.debug("TestController:: fetchdetails() method starts");
        return service.fetchdetails();

    }

    @PostMapping
    public User createuser(@RequestBody User user) {
        logger.debug("TestController:: createuser() method starts");

        return service.registerdetails(user);


    }

    @GetMapping("/{username}")
    public ResponseEntity<User> fetchbyname(@PathVariable String username) {
        logger.debug("TestController:: fetchbyname() method starts");


        return service.Fetchuserbyname(username);
    }

    @PutMapping("/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody User user) {
        logger.debug("TestController:: updateUser() method starts");

        return service.UpdateuserByname(username, user);
    }

    @DeleteMapping("/hard/{username}")
    public ResponseEntity<HttpStatus> deletebyname(@PathVariable String username) {
        logger.debug("TestController:: deletebyname() method starts");

        return service.deleteuser(username);
    }

    @PostMapping("/authenticateuser")
    public String authenticateUser(@RequestBody User user) {
        logger.debug("TestController:: authenticateUser() method starts");

        return service.authencatedUser(user);
    }


    @GetMapping("/duplicates")
    public List<Object> checkdupilecates() {
        logger.debug("TestController:: checkdupilecates() method starts");

        return service.CheckingDupilcateemailandmobileno();
    }


    @PutMapping("/soft/{username}")
    public void softdelete1(@PathVariable String username) {
        logger.warn("TestController:: softdelete1() method starts");

        service.softdelete1(username);
    }

    @GetMapping("/search/username/mailid")
    public ResponseEntity<List<User>> searchbycombinations(
                                                   @RequestParam(name="username",required = false) String username,
                                                   @RequestParam(name="mailid",required = false) String mailid ) {


        logger.debug("TestController:: searchbycombinations method starts");

        return ResponseEntity.ok(service.searchusers(username,mailid));


    }

}

