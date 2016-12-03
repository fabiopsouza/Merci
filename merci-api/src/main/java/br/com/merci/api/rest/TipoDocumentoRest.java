package br.com.merci.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.merci.core.service.TipoDocumentoService;
import br.com.merci.domain.http.HttpResponse;
import br.com.merci.domain.model.TipoDocumento;

@RestController
@RequestMapping("/api/tipoDocumento")
public class TipoDocumentoRest {

	@Autowired
	private TipoDocumentoService service;

	@RequestMapping(method = RequestMethod.GET)
	public HttpResponse findAll() {
		try {
			return new HttpResponse(service.findAll());
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
	public HttpResponse save(TipoDocumento tipoDocumento) {
		try {
			service.save(tipoDocumento);
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