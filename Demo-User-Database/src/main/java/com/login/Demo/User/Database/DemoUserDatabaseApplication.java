package com.login.Demo.User.Database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.login.Demo.User.Database.Entities")
@SpringBootApplication
public class DemoUserDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoUserDatabaseApplication.class, args);
	}

}
