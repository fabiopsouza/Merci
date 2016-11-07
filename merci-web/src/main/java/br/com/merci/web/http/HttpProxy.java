package br.com.merci.web.http;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.merci.domain.http.HttpResponse;

@Component
public class HttpProxy {

	private final String api = "http://localhost:8081/api/";
	
	public Object getObject(String uri){
		RestTemplate restTemplate = new RestTemplate();
		HttpResponse response = restTemplate.getForObject(api + uri, HttpResponse.class);
		return response.getData();
	}
	
}
