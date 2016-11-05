package br.com.merci.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "br.com.merci.api", "br.com.merci.core" })
public class MerciApiConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(MerciApiConfiguration.class);
	}

}