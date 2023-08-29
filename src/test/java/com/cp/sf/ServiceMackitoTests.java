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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ServiceMackitoTests.class })
public class ServiceMackitoTests {
    @Mock
    USerRepo userrepo;

    @InjectMocks
    UserServiceimpl service;

    public List<User> myuser;

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
    public void Test_fetchuserbyname(){
        List<User> myusers=new ArrayList<User>();
        myusers.add(new User(21l,"prasad","Prasadreddy","$2a$10$.umAouzjqWQgYsGHD3BRFeG0iioBM33WaOYgbrtSMk3bFi3CM6nZ","prasadreddy2020@gmail.com",9494752020l,1,"prasadreddy","paramesh"));
        myusers.add(new User(22l,"paramesh","parameshreddy","aOYgbrtSMk3bFi3CM6nZ$2a$10$.umAouzjqWQgYsGHD3BRFeG0iioBM33W","paramesh9878@gmail.com",985747778l,1,"parameshreddy","prasad"));
     String input="prasad";

       // when(userrepo.findById(input)).thenReturn(myuser);
         assertEquals(input,service.Fetchuserbyname(input).getStatusCode());


    }

}
