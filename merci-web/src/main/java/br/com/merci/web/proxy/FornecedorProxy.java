package br.com.merci.web.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.merci.domain.exception.HttpResponseException;
import br.com.merci.domain.http.HttpResponse;
import br.com.merci.domain.model.Fornecedor;
import br.com.merci.web.http.HttpProxy;

@Component
public class FornecedorProxy {

	@Autowired
	private HttpProxy proxy;
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> list() throws HttpResponseException{
		HttpResponse response = proxy.getObject("fornecedor", (new ArrayList<Fornecedor>()).getClass());
		return (List<Fornecedor>) response.getData();
	}
	
}
