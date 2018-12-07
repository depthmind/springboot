package com.dynastyTour.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dynastyTour.sys.mapper")
public class DynastyTourApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynastyTourApplication.class, args);
	}
}
