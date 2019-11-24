package com.CALV.RilDilBBQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//This annotation marks this class as a Configuration class for Java based configuration. It enables component scanning to discover beans. All @Controller 
//classes are discovered by this annotation. This also starts the auto configuration of SpringBoot. It is a combination of @Configuration, 
//@EnableConfiguration, and @ComponentScan 
@SpringBootApplication
//This annotation enables Java Persistence API. This is the JAVA ORM standard for storing, accessing, and managing objects in a database. Persistence means
//any object which outlives the program.
@EnableJpaAuditing
public class RilDilBbqApplication {

	public static void main(String[] args) {
		SpringApplication.run(RilDilBbqApplication.class, args);
	}

}
