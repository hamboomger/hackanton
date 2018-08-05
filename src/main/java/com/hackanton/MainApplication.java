package com.hackanton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ddorochov
 */
@SpringBootApplication
@ComponentScan("com.hackanton")
@EnableJpaRepositories("com.hackanton")
@EnableTransactionManagement
@EnableScheduling
@EntityScan("com.hackanton")
public class  MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}