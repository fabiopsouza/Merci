package br.com.merci.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "br.com.merci.core", "br.com.merci.store" })
public class MerciCoreConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(MerciCoreConfiguration.class);
	}
	
}
