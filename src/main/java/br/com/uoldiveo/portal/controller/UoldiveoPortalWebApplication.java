package br.com.uoldiveo.portal.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication(scanBasePackages= {"br.com.uoldiveo.portal.service"})
@EnableCircuitBreaker
public class UoldiveoPortalWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(UoldiveoPortalWebApplication.class, args);
	}
}