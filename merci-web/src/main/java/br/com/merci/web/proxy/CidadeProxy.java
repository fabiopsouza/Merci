package br.com.merci.web.proxy;

import org.springframework.stereotype.Component;

@Component
public class CidadeProxy {

//	@Autowired
//	private HttpProxy proxy;
//	
//	@SuppressWarnings("unchecked")
//	public PageImplBean<Cidade> listPageable(Integer page, Integer size) throws HttpResponseException{
//		//HttpResponse response = proxy.getObject(String.format("cidade/%1$d/%2$d", page, size), (new PageImplBean<Cidade>()).getClass());
//		
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("nome", "guaru");
//		HttpResponse response = proxy.getObject(String.format("cidade/%1$d/%2$d", page, size), HttpMethod.POST, (new PageImplBean<Cidade>()).getClass(), params);
//		return (PageImplBean<Cidade>) response.getData();
//	}

}
