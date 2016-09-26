package com.xin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xin.mapper")
public class MyBatisTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatisTestApplication.class, args);
	}
}
