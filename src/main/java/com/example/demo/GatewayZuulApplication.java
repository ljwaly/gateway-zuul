package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(GatewayZuulApplication.class, args);
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String port = environment.getProperty("server.port");
		System.out.println("***********************************************");
		System.out.println("		Gateway-Zuul");

		System.out.println("		http://localhost:" + port);
		
		System.out.println("***********************************************");
		
	}
}
