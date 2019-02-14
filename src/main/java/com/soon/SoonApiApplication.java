package com.soon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
public class SoonApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(SoonApiApplication.class, args);
	}

}
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) // datasource 설정이 없는 경우 해당 어노테이션 사용하면 정상 기동됨
// application.yml

