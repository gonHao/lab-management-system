package com.kmust.labmanagementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kmust.labmanagementsystem.m")
public class LabManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabManagementSystemApplication.class, args);
	}

}
