package com.cp.sf;

import com.cp.sf.Entity.User;
import com.cp.sf.Repository.USerRepo;
import com.cp.sf.Service.IUserService;
import com.cp.sf.Service.UserServiceimpl;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ServiceMackitoTests.class })
public class ServiceMackitoTests {
    @Mock
    USerRepo userrepo;

    @InjectMocks
    UserServiceimpl service;

    public List<User> myuser;
    private Object ResponseEntity;

    @Test
    @Order(1)
    public void test_fetchallusers(){
        List<User> myusers=new ArrayList<User>();
myusers.add(new User(21l,"prasad","Prasadreddy","$2a$10$.umAouzjqWQgYsGHD3BRFeG0iioBM33WaOYgbrtSMk3bFi3CM6nZ","prasadreddy2020@gmail.com",9494752020l,1,"prasadreddy","paramesh"));
myusers.add(new User(22l,"paramesh","parameshreddy","aOYgbrtSMk3bFi3CM6nZ$2a$10$.umAouzjqWQgYsGHD3BRFeG0iioBM33W","paramesh9878@gmail.com",985747778l,1,"parameshreddy","prasad"));

     when(userrepo.findAll()).thenReturn(myusers);
     service.fetchdetails();
        assertEquals(2,service.fetchdetails().size());
    }


    @Test
    @Order(2)
    public void Test_registerdetails(){

        User user1=new User(23l,"Ravi","Ravindrareddy","Ravi@123","Ravindrareddy2020@gmail.com",84856754367l,1,"Ravireddy","prasad");


        when(userrepo.save(user1)).thenReturn(user1);
        service.registerdetails(user1);
        assertEquals(user1,service.registerdetails(user1));


    }

    @Test
    @Order(3)
    public void Test_Fetchuserbyname(){


        User user1=new User(23l,"Ravi","Ravindrareddy","Ravi@123","Ravindrareddy2020@gmail.com",84856754367l,1,"Ravireddy","prasad");

        String username1="prasad";
        when(userrepo.findById(username1)).thenReturn(Optional.of(user1));
        service.Fetchuserbyname(username1);
    }


    @Test
    @Order(4)
    public void Test_UpdateuserByname(){
        User user1=new User(23l,"Ravi","Ravindrareddy","Ravi@123","Ravindrareddy2020@gmail.com",84856754367l,1,"Ravireddy","prasad");

        String username1="prasad";
        when(userrepo.findById(username1)).thenReturn(Optional.of(user1));
        service.UpdateuserByname(username1,user1);
}
   @Test
   @Order(5)
       public void Test_deleteuser(){
       User user1=new User(23l,"Ravi","Ravindrareddy","Ravi@123","Ravindrareddy2020@gmail.com",84856754367l,1,"Ravireddy","prasad");

       String username1="prasad";
       when(userrepo.findById(username1)).thenReturn(Optional.of(user1));


        service.deleteuser(username1);
       }

       @Test
       @Order(6)
      public void Test_authencatedUser(){
           User user1=new User(23l,"Ravi","Ravindrareddy","Ravi@123","Ravindrareddy2020@gmail.com",84856754367l,1,"Ravireddy","prasad");



      }

    /*  @Test
      @Order(7)
      public void Test_CheckingDupilcateemailandmobileno(){

          User user1=new User(23l,"Ravi","Ravindrareddy","Ravi@123","Ravindrareddy2020@gmail.com",84856754367l,1,"Ravireddy","prasad");


          when(userrepo.searchDuplicatesinEmailAndPassword()).thenReturn(Collections.singletonList((List<User>) user1));
        service.CheckingDupilcateemailandmobileno();


      }
      */


    @Test
    @Order(9)
    public void Test_softdelete(){
        User user1=new User(23l,"Ravi","Ravindrareddy","Ravi@123","Ravindrareddy2020@gmail.com",84856754367l,1,"Ravireddy","prasad");

        String username1="prasad";

        when(userrepo.findById(username1)).thenReturn(Optional.of(user1));
         service.softdelete1(username1);


    }
    @Test
    @Order(10)
    public void Test_searchusers(){
        List<User> myusers=new ArrayList<User>();
        myusers.add(new User(21l,"prasad","Prasadreddy","$2a$10$.umAouzjqWQgYsGHD3BRFeG0iioBM33WaOYgbrtSMk3bFi3CM6nZ","prasadreddy2020@gmail.com",9494752020l,1,"prasadreddy","paramesh"));
        myusers.add(new User(22l,"paramesh","parameshreddy","aOYgbrtSMk3bFi3CM6nZ$2a$10$.umAouzjqWQgYsGHD3BRFeG0iioBM33W","paramesh9878@gmail.com",985747778l,1,"parameshreddy","prasad"));

        String name="prasad";
        String mail="prasad@1234";

        when(userrepo.findByUsernameOrMailid(name,mail)).thenReturn(myusers);
        service.searchusers(name,mail);
    }





}
