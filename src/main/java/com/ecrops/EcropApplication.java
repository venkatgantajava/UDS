package com.ecrops;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.ecrops.config.CustomPasswordEncoder;

@SpringBootApplication
public class EcropApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(EcropApplication.class);
		
		
	}

	public static void main(String[] args) {
SpringApplication.run(EcropApplication.class, args);
		
//		CustomPasswordEncoder customPasswordEncoder=new CustomPasswordEncoder();
//		
//		String encodePassword= (customPasswordEncoder.encode("ADMIN@ap555")) ;
//		//String encodePassword=customPasswordEncoder.encode(customPasswordEncoder.encode("ADMIN@ap555"));
//		System.out.println("encodePassword---->"+encodePassword);
	}

}
