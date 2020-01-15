package com.li.springBootPro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "com.li.springBootPro.mapper")
public class SpringBootProApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProApplication.class, args);
	}

}
