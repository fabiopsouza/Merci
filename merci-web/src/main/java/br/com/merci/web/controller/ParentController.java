package br.com.merci.web.controller;

import org.springframework.web.client.RestTemplate;

import br.com.merci.domain.http.HttpResponse;

public class ParentController {

	private final String api = "http://localhost:8080/api/";
	
	public Object getObject(String uri){
		RestTemplate restTemplate = new RestTemplate();
		HttpResponse response = restTemplate.getForObject(api + uri, HttpResponse.class);
		return response.getData();
	}
	
}
