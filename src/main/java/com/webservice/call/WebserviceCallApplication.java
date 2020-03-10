package com.webservice.call;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:local.properties")
@SpringBootApplication
public class WebserviceCallApplication extends SpringBootServletInitializer {

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WebserviceCallApplication.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(WebserviceCallApplication.class, args);
	}
}