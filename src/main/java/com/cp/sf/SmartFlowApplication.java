package com.cp.sf;

import ch.qos.logback.core.CoreConstants;
import com.cp.entity.User;
import com.cp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SmartFlowApplication {



	public static void main(String[] args) {

		ApplicationContext con = SpringApplication.run(SmartFlowApplication.class, args);
		UserService service = con.getBean("userServiceimpl", UserService.class);



		User user = new User();
		insta.setId(1);
		insta.setFirstname("prasad");
		insta.setLastname("atla");
		insta.setPassword("pasadu");
		service.registerAccount(user);


	}
}