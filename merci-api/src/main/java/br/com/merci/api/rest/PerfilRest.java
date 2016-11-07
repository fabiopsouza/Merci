package br.com.merci.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.merci.core.service.PerfilService;
import br.com.merci.domain.http.HttpResponse;

@RestController
@RequestMapping("/api/perfil")
public class PerfilRest {

	@Autowired
	private PerfilService service;

	@RequestMapping(path = "/{nomeUsuario}", method = RequestMethod.GET)
	public HttpResponse buscarPerfisPeloNomeUsuario(@PathVariable String nomeUsuario) {
		try {
			return new HttpResponse(service.buscarPerfisPeloNomeUsuario(nomeUsuario));
		} catch (Exception e) {
			return new HttpResponse(e.getMessage());
		}
	}

}