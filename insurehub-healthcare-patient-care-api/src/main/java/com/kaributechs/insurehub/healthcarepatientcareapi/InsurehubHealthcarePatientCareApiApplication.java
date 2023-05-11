package com.kaributechs.insurehub.healthcarepatientcareapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class InsurehubHealthcarePatientCareApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsurehubHealthcarePatientCareApiApplication.class, args);
		System.out.println("Project is Running!!");
	}


	@Bean
	public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}