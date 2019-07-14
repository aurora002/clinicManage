package com.dev.clinicapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = {"com.dev.clinicapp"})
public class ClinicAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicAppApplication.class, args);
	}

}
