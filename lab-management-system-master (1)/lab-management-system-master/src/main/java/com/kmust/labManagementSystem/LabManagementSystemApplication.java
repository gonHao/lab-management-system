package com.kmust.labManagementSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kmust.labManagementSystem.mapper")
public class LabManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabManagementSystemApplication.class, args);
	}

}
