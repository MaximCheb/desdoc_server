package com.doc.concept.server;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;


@SpringBootApplication
@EnableAutoConfiguration
@SecurityScheme(name = "gcc-user-api", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class DesdocServerApplication {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(DesdocServerApplication.class);
		application.addListeners(new ApplicationPidFileWriter("./bin/api-app.pid"));
		application.run();
	}

}
