package com.dev.clinicapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ClinicAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicAppApplication.class, args);
	}

}
