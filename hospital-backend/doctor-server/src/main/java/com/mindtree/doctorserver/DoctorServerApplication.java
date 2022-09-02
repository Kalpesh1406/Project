package com.mindtree.doctorserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DoctorServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorServerApplication.class, args);
	}

}
