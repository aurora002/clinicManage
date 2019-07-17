package com.dev.clinicapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })
public class ClinicAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicAppApplication.class, args);
	}

}
