package com.cansazak.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.cansazak"})
@ComponentScan(basePackages = {"com.cansazak"})
@EnableJpaRepositories(basePackages = {"com.cansazak"})
@SpringBootApplication
public class ETicaretUrunKataloguStarter {

	public static void main(String[] args) {
		SpringApplication.run(ETicaretUrunKataloguStarter.class, args);
	}

}
