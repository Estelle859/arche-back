package com.online.eLibrairie;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.online.eLibrairie.models.Client;
import com.online.eLibrairie.services.ClientService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);		
		
	}

}
