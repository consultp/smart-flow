package com.cp.sf;

import ch.qos.logback.core.CoreConstants;
import com.cp.entity.Instagram;
import com.cp.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SmartFlowApplication {

	@Autowired
	private IService service;

	public static void main(String[] args) {

		ApplicationContext con = SpringApplication.run(SmartFlowApplication.class, args);
		IService service = con.getBean("serviceimpl", IService.class);



		Instagram insta = new Instagram();
		insta.setId(1);
		insta.setFirstname("prasad");
		insta.setLastname("atla");
		insta.setPassword("pasadu");
		service.registerAccount(insta);


	}
}