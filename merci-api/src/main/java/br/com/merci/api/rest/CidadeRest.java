package br.com.merci.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.merci.core.service.CidadeService;
import br.com.merci.domain.http.HttpResponse;
import br.com.merci.domain.model.Cidade;

@RestController
@RequestMapping("/api/cidade")
public class CidadeRest {

	@Autowired
	private CidadeService service;

	@RequestMapping(method = RequestMethod.GET)
	public HttpResponse findAll() {
		try {
			return new HttpResponse(service.findAll());
		} catch (Exception e) {
			return new HttpResponse(e.getMessage());
		}
	}

	@RequestMapping(path = "/{page}/{size}", method = RequestMethod.POST)
	public HttpResponse findAllPageable(@PathVariable Integer page, @PathVariable Integer size, @RequestParam("nome") String nome) {
		try {
			return new HttpResponse(service.findByNomeLikeIgnoreCasePageable(nome, new PageRequest(page, size)));
		} catch (Exception e) {
			return new HttpResponse(e.getMessage());
		}
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public HttpResponse findOne(@PathVariable Long id) {
		try {
			return new HttpResponse(service.findOne(id));
		} catch (Exception e) {
			return new HttpResponse(e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public HttpResponse save(Cidade cidade) {
		try {
			service.save(cidade);
		} catch (Exception e) {
			return new HttpResponse(e.getMessage());
		}

		return new HttpResponse(true);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public HttpResponse delete(Long id) {
		try {
			service.delete(id);
		} catch (Exception e) {
			return new HttpResponse(e.getMessage());
		}

		return new HttpResponse(true);
	}

}