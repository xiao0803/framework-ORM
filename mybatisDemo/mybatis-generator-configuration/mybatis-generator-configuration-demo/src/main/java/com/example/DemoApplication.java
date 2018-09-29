package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import tk.mybatis.spring.annotation.MapperScan;
/**
 * @author xiaolijun
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.example.mapper.**")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
