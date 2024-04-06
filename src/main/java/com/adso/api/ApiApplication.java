package com.adso.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.adso.api")
public class ApiApplication {

	public static void main(String[] args) {
		System.out.println("Hellow ADSO, This is my Aplication!");
		SpringApplication.run(ApiApplication.class, args);
	}

}
