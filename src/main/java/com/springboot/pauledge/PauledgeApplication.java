package com.springboot.pauledge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class PauledgeApplication {
	
	public static String generateOTP() {
		int randomPin = (int) (Math.random()*900000)+100000;
        String otp  = String.valueOf(randomPin);
        return otp;
	}

	public static void main(String[] args) {
		SpringApplication.run(PauledgeApplication.class, args);
		System.out.println("PAULEDGE APPLICATION STARTED");
		
	}	
}
