package com.mounika.starter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.mounika.controller.CsvParserController;

@SpringBootApplication(scanBasePackages = {"com.mounika.controller", "com.mounika.model", "com.mounika.service"})
public class CsvParserApplication {
	public static void main(String[] args) {
		SpringApplication.run(CsvParserApplication.class, args);
	}
}
