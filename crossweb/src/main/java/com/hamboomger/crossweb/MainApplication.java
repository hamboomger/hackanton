package com.hamboomger.crossweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ddorochov
 */
@SpringBootApplication
@ComponentScan("com.hamboomger")
@EnableJpaRepositories("com.hamboomger")
@EnableTransactionManagement
@EntityScan("com.hamboomger")
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}