package br.com.merci.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.merci.core.service.UsuarioService;
import br.com.merci.domain.http.HttpResponse;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRest {

	@Autowired
	private UsuarioService service;

	@RequestMapping(path = "/{nome}", method = RequestMethod.GET)
	public HttpResponse buscarPorNome(@PathVariable String nome) {
		try {
			return new HttpResponse(service.buscarPorNome(nome));
		} catch (Exception e) {
			return new HttpResponse(e.getMessage());
		}
	}

}