package br.com.merci.web.proxy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import br.com.merci.domain.bean.PageImplBean;
import br.com.merci.domain.exception.HttpResponseException;
import br.com.merci.domain.http.HttpResponse;
import br.com.merci.domain.model.Cidade;
import br.com.merci.web.http.HttpProxy;

@Component
public class CidadeProxy {

	@Autowired
	private HttpProxy proxy;
	
	@SuppressWarnings("unchecked")
	public PageImplBean<Cidade> listPageable(Integer page, Integer size) throws HttpResponseException{
		//HttpResponse response = proxy.getObject(String.format("cidade/%1$d/%2$d", page, size), (new PageImplBean<Cidade>()).getClass());
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("nome", "guaru");
		HttpResponse response = proxy.getObject(String.format("cidade/%1$d/%2$d", page, size), HttpMethod.POST, (new PageImplBean<Cidade>()).getClass(), params);
		return (PageImplBean<Cidade>) response.getData();
	}

}
