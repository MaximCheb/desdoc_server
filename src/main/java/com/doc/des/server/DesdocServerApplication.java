package com.doc.des.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.doc.des.server.upload.service.StorageService;

@SpringBootApplication
public class DesdocServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesdocServerApplication.class, args);
	}
	@Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.init();
        };
    }
}
