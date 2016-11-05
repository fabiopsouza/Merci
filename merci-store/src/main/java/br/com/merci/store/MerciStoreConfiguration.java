package br.com.merci.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("br.com.merci.domain.model")
public class MerciStoreConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(MerciStoreConfiguration.class);
	}
	
}
