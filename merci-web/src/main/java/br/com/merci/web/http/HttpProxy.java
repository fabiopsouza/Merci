package br.com.merci.web.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.merci.domain.exception.HttpResponseException;
import br.com.merci.domain.http.HttpResponse;

@Component
public class HttpProxy {

	@Autowired
	private RestTemplate template;

	@Autowired
	private HttpHeaders headers;

	@Autowired
	private ObjectMapper mapper;

	private final String api = "http://localhost:8081/api/";

	public HttpResponse getObject(String uri, Class<?> responseClass) throws HttpResponseException {
		return exchange(null, api + uri, HttpMethod.GET, responseClass);
	}
	
	public <E> HttpResponse exchange(E data, String uri, HttpMethod method, Class<?> responseClass) throws HttpResponseException {

		try {
			
			HttpEntity<E> request = new HttpEntity<>(headers);
			ResponseEntity<HttpResponse> result = template.exchange(uri, method, request, HttpResponse.class);
			HttpResponse response = result.getBody();

			if (response == null)
				throw new HttpResponseException("Responsa do servidor nula");

			if(!response.isSuccess)
				throw new HttpResponseException(response.error, response.errorDetail, response.field, response.code);
			
			if(response.getData() != null)
				response.setData(mapper.convertValue(response.getData(), responseClass));

			return response;
			
		} catch (RestClientException e) {
			throw new HttpResponseException("Erro na comunicação com o servidor", e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new HttpResponseException("Erro ao converter objeto vindo do servidor", e.getMessage());
		} catch (Exception e) {
			throw new HttpResponseException("Houve um erro inesperado", e.getMessage());
		}
	}

}
