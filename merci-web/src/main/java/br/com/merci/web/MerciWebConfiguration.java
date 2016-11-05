package br.com.merci.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.merci.api.MerciApiConfiguration;

@SpringBootApplication
public class MerciWebConfiguration {

	public static void main(String[] args) {
		Object[] sources = {MerciWebConfiguration.class, MerciApiConfiguration.class};
		SpringApplication.run(sources, args);
	}

}
